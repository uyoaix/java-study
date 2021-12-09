package com.study.yufei.io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Discard服务器：仅仅读取客户端通道的输入数据，读取完成后直接关闭客户端通道，并且读取到的数据直接抛弃掉
 *
 * @date 2021/12/8 11:32 AM
 */
public class NioDiscardServer {

    private static final Logger log = LoggerFactory.getLogger(NioDiscardServer.class);

    public static void startServer() throws IOException {

        // 获取选择器
        Selector selector = Selector.open();

        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(18889));
        log.info("服务器启动成功！");

        // 将通道 接收新连接 IO事件，注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 轮询IO就绪事件（选择键集合）
        while (selector.select() > 0) {
            // 获取选择键集合
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();

            while (selectionKeys.hasNext()) {
                // 获取单个的选择键，并处理
                SelectionKey selectionKey = selectionKeys.next();
                // 判断key是具体的什么事件
                if (selectionKey.isAcceptable()) {

                    // 若选择键的IO事件是 连接就绪 事件，就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    // 将新连接切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 将新连接的通道的可读事件，注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 若选择键的IO事件是可读事件，读取数据
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    // 读取数据，然后丢弃
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    if ((length = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        log.info(new String(buffer.array(), 0, length));
                        buffer.clear();
                    }
                    socketChannel.close();
                }
                selectionKeys.remove();
            }
        }
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        startServer();
    }
}
