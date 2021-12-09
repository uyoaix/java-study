package com.study.yufei.io.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
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
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey selectionKey = keyIterator.next();
                    dispatch(selectionKey);
                }
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

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
