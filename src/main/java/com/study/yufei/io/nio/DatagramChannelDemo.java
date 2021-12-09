package com.study.yufei.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 数据报通道
 *
 * @date 2021/12/7 9:01 PM
 */
public class DatagramChannelDemo {


    public static void main(String[] args) throws IOException {

        // 开启数据报通道
        DatagramChannel dataGramChannel = DatagramChannel.open();
        dataGramChannel.configureBlocking(false);

        // 如果需要接收数据，需要绑定端口
        dataGramChannel.socket().bind(new InetSocketAddress(18080));

        // 缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 从datagramChannel读入，再写入到buffer缓冲区
        // 返回数据是发送端的ip和端口
        SocketAddress clientAddr = dataGramChannel.receive(buffer);

        // 写入数据报通道
        // 把缓冲区翻转成可读模式
        buffer.flip();
        dataGramChannel.send(buffer, new InetSocketAddress("127.0.0.1", 18888));
        buffer.clear();

        // 关闭数据报通道
        dataGramChannel.close();
    }
}
