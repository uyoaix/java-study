package com.study.yufei.io.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程反应器的实践案例设计如下:
 * (1)引入多个选择器。
 * (2)设计一个新的子反应器(SubReactor)类，子反应器负责查询一个选择器。
 * (3)开启多个处理线程，一个处理线程负责执行一个子反应器(SubReactor)
 *
 * @author yufei.wang
 * @date 2021/12/09
 */
public class MultiThreadEchoServerReactor {

    private final Logger log = LoggerFactory.getLogger(MultiThreadEchoServerReactor.class);

    ServerSocketChannel serverSocketChannel;
    AtomicInteger next = new AtomicInteger(0);

    // 选择器集合，引入多个选择器
    Selector[] selectors = new Selector[2];

    // 引入多个子反应器
    SubReactor[] subReactors = null;

    MultiThreadEchoServerReactor() throws IOException {

        // 初始化选择器
        selectors[0] = Selector.open(); // 用于监听连接事件
        selectors[1] = Selector.open(); // 用于监听传输事件

        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(18888));
        serverSocketChannel.configureBlocking(false);

        // 第一个选择器，负责监听连接事件
        SelectionKey connectSk = serverSocketChannel.register(selectors[0], SelectionKey.OP_ACCEPT);

        // 绑定handler：新连接监控handler
        connectSk.attach(new AcceptorHandler());

        SubReactor subReactor1 = new SubReactor(selectors[0]);
        SubReactor subReactor2 = new SubReactor(selectors[1]);

        subReactors = new SubReactor[]{subReactor1, subReactor2};
    }

    private void startService() {
        new Thread(subReactors[0]).start();
        new Thread(subReactors[1]).start();
    }

    class SubReactor implements Runnable {

        final Selector selector;

        SubReactor(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select(1000);
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    if(null == selectedKeys || selectedKeys.size() == 0){
                        continue;
                    }
                    Iterator<SelectionKey> it = selectedKeys.iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        dispatch(next);
                    }
                    selectedKeys.clear();
                }

            } catch (Exception e) {

            }
        }

        void dispatch(SelectionKey sk) {
            Runnable handler = (Runnable) sk.attachment();
            if (handler != null) {
                handler.run();
            }
        }

    }

    class AcceptorHandler implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                log.info("收到一个新连接");

                // 创建传输处理器，并且将传输通道注册到选择器2
                if (socketChannel != null) {
                    int index = next.get();
                    log.info("选择器的编号：" + index);
                    Selector selector = selectors[index];
                    new MultiThreadEchoHandler(selector, socketChannel);
                }

            } catch (Exception e) {

            }

            if(next.incrementAndGet() == selectors.length){
                next.set(0);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        MultiThreadEchoServerReactor serverReactor = new MultiThreadEchoServerReactor();
        serverReactor.startService();
    }

}
