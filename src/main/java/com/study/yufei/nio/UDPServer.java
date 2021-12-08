package com.study.yufei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @date 2021/12/8 10:40 AM
 */
public class UDPServer {

    public void receive() throws IOException {
        DatagramChannel dChannel = DatagramChannel.open();
        dChannel.configureBlocking(false);
        dChannel.socket().bind(new InetSocketAddress("127.0.0.1", 18888));
        System.out.println("UDP服务器启动成功！");

        // 开启一个通道选择器
        Selector selector = Selector.open();
        // 将通道注册到选择器
        dChannel.register(selector, SelectionKey.OP_READ);
        // 通过选择器，查询IO事件
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 迭代IO事件
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 可读事件，有数据到来
                if (selectionKey.isReadable()) {
                    SocketAddress socketAddress = dChannel.receive(buffer);
                    buffer.flip();

                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
            }
            iterator.remove();
        }

        selector.close();
        dChannel.close();
    }

    public static void main(String[] args) throws IOException {
        new UDPServer().receive();
    }

}
