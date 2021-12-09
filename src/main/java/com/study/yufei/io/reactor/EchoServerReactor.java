package com.study.yufei.io.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 在单线程反应器模式中，Reactor反应器和Handler处理器，都执行在同一条线程上。
 * 这 样，带来了一个问题:当其中某个Handler阻塞时，会导致其他所有的Handler都得不到执行。
 * 在这种场景下，被阻塞的Handler不仅仅负责输入和输出处理的传输处理器，还包括负 责新连接监听的AcceptorHandler处理器，
 * 这就可能导致服务器无响应。这个是非常严重的 问题。
 * 因为这个缺陷，因此单线程反应器模型在生产场景中使用得比较少。
 *
 * @date 2021/12/9 10:34 AM
 */
public class EchoServerReactor implements Runnable {

    Selector selector;

    ServerSocketChannel serverSocketChannel;

    EchoServerReactor() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(18888));

        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new AcceptorHandler());
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey selectionKey = keyIterator.next();
                    dispatch(selectionKey);
                }
                selectedKeys.clear();
            }
        } catch (Exception e) {

        }
    }

    void dispatch(SelectionKey selectionKey) {

        Runnable handler = (Runnable) (selectionKey.attachment());

        if (handler != null) {
            handler.run();
        }
    }

    class AcceptorHandler implements Runnable {
        @Override
        public void run() {
            try {
                // 接收新连接
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new EchoHandler(selector, socketChannel);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new EchoServerReactor()).start();
    }
}
