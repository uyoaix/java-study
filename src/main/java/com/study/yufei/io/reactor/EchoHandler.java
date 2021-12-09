package com.study.yufei.io.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author yufei.wang
 * @date 2021/12/9 11:07 AM
 */
public class EchoHandler implements Runnable {

    private final Logger log = LoggerFactory.getLogger(EchoHandler.class);

    final SocketChannel channel;
    final SelectionKey selectionKey;
    final ByteBuffer buffer = ByteBuffer.allocate(1024);
    static final int RECIEVING = 0, SENDING = 1;
    int state = RECIEVING;

    EchoHandler(Selector selector, SocketChannel socketChannel) throws IOException {
        channel = socketChannel;
        channel.configureBlocking(false);
        // 先获取选择键，再设置感兴趣的IO事件
        selectionKey = channel.register(selector, 0);
        // 将当前Handler作为选择键的附件，一个连接对应一个处理器实例
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }


    @Override
    public void run() {
        try {
            if(state == SENDING){
                channel.write(buffer);
                buffer.clear();
                selectionKey.interestOps(SelectionKey.OP_READ);
                state = RECIEVING;
            } else if(state == RECIEVING){
                int length = 0;
                while ((length = channel.read(buffer)) > 0){
                    log.info(new String(buffer.array(), 0 , length));
                }
                buffer.flip();
                selectionKey.interestOps(SelectionKey.OP_WRITE);
                state = SENDING;
            }

        } catch (Exception e){

        }
    }
}
