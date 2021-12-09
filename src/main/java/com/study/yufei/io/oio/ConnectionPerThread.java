package com.study.yufei.io.oio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date 2021/12/9 10:14 AM
 */
public class ConnectionPerThread implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(19999);

            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                // 每个连接都分配一个线程处理
                Handler handler = new Handler(socket);
                new Thread(handler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler implements Runnable {

        Socket socket;

        Handler(Socket socket) {
            socket = socket;
        }

        public void run() {
            while (true) {
                try {
                    byte[] input = new byte[1024];
                    socket.getInputStream().read(input);

                    byte[] output = null;
                    socket.getOutputStream().write(output);
                } catch (Exception e) {

                }
            }
        }
    }
}
