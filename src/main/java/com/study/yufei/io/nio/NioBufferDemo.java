package com.study.yufei.io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;

/**
 * @author yufei.wang
 * @date 2021/11/30 20:41
 */
public class NioBufferDemo {

    static IntBuffer intBuffer = null;

    static Logger log = LoggerFactory.getLogger(NioBufferDemo.class);

    public static void allocateTest() {
        // 初始化时是读模式，此时可以向缓冲区写入数据
        intBuffer = IntBuffer.allocate(20);
        log.debug("------------after allocate------------------");
        log.debug("position=" + intBuffer.position());
        log.debug("limit=" + intBuffer.limit());
        log.debug("capacity=" + intBuffer.capacity());
    }

    public static void putTest() {
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }

        log.debug("------------after put------------------");
        log.debug("position=" + intBuffer.position());
        log.debug("limit=" + intBuffer.limit());
        log.debug("capacity=" + intBuffer.capacity());
    }

    public static void flipTest() {
        // 翻转缓冲区，会变成读模式，此时可以从缓冲区读取数据
        intBuffer.flip();

        log.debug("------------after flip------------------");
        log.debug("position=" + intBuffer.position());
        log.debug("limit=" + intBuffer.limit());
        log.debug("capacity=" + intBuffer.capacity());
    }

    public static void getTest() {
        // 先读取2个值
        for (int i = 0; i < 2; i++) {
            int j = intBuffer.get();
            log.debug("j = " + j);
        }

        //输出缓冲区的主要属性值
        log.info("---------after get 2 int --------------");
        log.info("position=" + intBuffer.position());
        log.info("limit=" + intBuffer.limit());
        log.info("capacity=" + intBuffer.capacity());

        //再读 3 个数据
        for (int i = 0; i < 3; i++) {
            int j = intBuffer.get();
            log.info("j = " + j);
        }

        log.info("---------after get 3 int --------------");
        log.info("position=" + intBuffer.position());
        log.info("limit=" + intBuffer.limit());
        log.info("capacity=" + intBuffer.capacity());
    }

    public static void rewindTest(){
        // 已经读完的数据，如果需要再度一遍
        intBuffer.rewind();
        log.debug("------------after rewind------------------");
        log.debug("position=" + intBuffer.position());
        log.debug("limit=" + intBuffer.limit());
        log.debug("capacity=" + intBuffer.capacity());
    }

    public static void markAndResetTest(){

    }

    public static void clearTest(){
        intBuffer.clear();
    }

    public static void main(String[] args) {
        allocateTest();
        System.out.println();
        putTest();
        System.out.println();
        flipTest();
        System.out.println();
        getTest();
        System.out.println();
        rewindTest();
    }
}
