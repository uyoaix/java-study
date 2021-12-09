package com.study.yufei.io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @date 2021/12/8 4:48 PM
 */
public class NioDiscardClient {

    private final static Logger log = LoggerFactory.getLogger(NioDiscardClient.class);

    public static void startClient() throws IOException {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 18889);
        // SocketChannel客户端连接服务器
        SocketChannel socketchannel = SocketChannel.open(socketAddress);
        socketchannel.configureBlocking(false);

        while (!socketchannel.finishConnect()){

        }
        log.info("客户端连接成功！");
        System.out.println("请输入要发送的内容：");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String next = scanner.next();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put((new Date() + " >>" + next).getBytes());
            buffer.flip();
            socketchannel.write(buffer);
            buffer.clear();
        }

        //socketchannel.shutdownOutput();
        //socketchannel.close();
    }

    public static void main(String[] args) throws IOException {
        startClient();
    }
}
