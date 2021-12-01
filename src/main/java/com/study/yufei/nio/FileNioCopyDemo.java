package com.study.yufei.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yufei.wang
 * @date 2021/12/01 13:45
 */
public class FileNioCopyDemo {

    private final static Logger log = LoggerFactory.getLogger(FileNioCopyDemo.class);

    public static void main(String[] args) {

        // 源
        String sourcePath = "gc.log";

        // 目标
        String destPath = "gc.log.copy";

        File srcFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            if (!destFile.exists()) {
                destFile.createNewFile();
            }

            long startTime = System.currentTimeMillis();
            FileInputStream fis = null;
            FileOutputStream fos = null;
            FileChannel inChannel = null;
            FileChannel outChannel = null;

            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(destFile);
                inChannel = fis.getChannel();
                outChannel = fos.getChannel();

                int length = -1;
                // 新建ByteBuffer 处于写入模式
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                // 从输入通道读取到 buf
                while ((length = inChannel.read(byteBuffer)) != -1) {
                    // buf 第一次模式切换，变成读取模式
                    byteBuffer.flip();

                    int outLength = 0;
                    while ((outLength = outChannel.write(byteBuffer)) != 0) {
                        log.debug("写入的字节数：" + outLength);
                    }

                    // buf 第二次模式切换，清除buffer,变为写入模式
                    byteBuffer.clear();
                }
                // 强制刷新到磁盘
                outChannel.force(true);
            } catch (Exception e) {

            } finally {
                if (outChannel != null) {
                    outChannel.close();
                    ;
                }
                if (fos != null) {
                    fos.close();
                }
                if (inChannel != null) {
                    inChannel.close();
                }
                if (fis != null) {
                    fis.close();
                }
            }

            long endTime = System.currentTimeMillis();
            log.info("base 复制耗时：" + (endTime - startTime));

        } catch (Exception e) {

        }


    }
}
