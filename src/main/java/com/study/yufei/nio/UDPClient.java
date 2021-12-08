package com.study.yufei.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @date 2021/12/8 10:27 AM
 */
public class UDPClient {

    public void send() throws IOException {

        DatagramChannel dChannel = DatagramChannel.open();
        dChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        System.out.println("UDP客户端启动成功！");
        System.out.println("请输入发送内容：");
        while (scanner.hasNext()) {
            String next = scanner.next();
            buffer.put((new Date() + " >>" + next).getBytes());
            buffer.flip();
            dChannel.send(buffer, new InetSocketAddress("127.0.0.1", 18888));
            buffer.clear();
        }

        dChannel.close();
    }

    public static void main(String[] args) throws IOException {
        new UDPClient().send();
    }
}
