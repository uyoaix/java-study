package com.study.yufei.io.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yufei.wang
 * @date 2021/12/10 10:21
 */
public class MultiThreadEchoHandler implements Runnable {

    private final Logger log = LoggerFactory.getLogger(MultiThreadEchoHandler.class);

    private final SocketChannel socketChannel;
    private final SelectionKey selectionKey;
    private final ByteBuffer buffer = ByteBuffer.allocate(1024);

    private final static int RECEIVING = 0, SENDING = 1;
    int state = RECEIVING;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    MultiThreadEchoHandler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true);

        selectionKey = socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);

        selector.wakeup();
        log.info("新的连接注册完成");
    }


    @Override
    public void run() {
        // 异步任务，在独立的线程池中执行
        threadPool.execute(new AsyncTask());
    }

    class AsyncTask implements Runnable {
        @Override
        public void run() {
            MultiThreadEchoHandler.this.asyncRun();
        }
    }


    public synchronized void asyncRun() {
        try {
            if (state == SENDING) {
                // 写入通道
                socketChannel.write(buffer);

                // 写完后，准备开始从通道读，ByteBuffer切换成写模式
                buffer.clear();
                selectionKey.interestOps(SelectionKey.OP_READ);

                state = RECEIVING;
            } else if (state == RECEIVING) {

                // 把客户端数据读入 ByteBuffer
                int length = 0;
                while ((length = socketChannel.read(buffer)) > 0) {
                    log.info(new String(buffer.array(), 0, length));
                }

                // 读完后，准备从缓冲区写入通道，ByteBuffer切换成读模式
                buffer.flip();
                // 读完后，注册write就绪事件
                selectionKey.interestOps(SelectionKey.OP_WRITE);
                // 读完后，进入发送状态
            }

        } catch (Exception e) {

        }
    }
}
