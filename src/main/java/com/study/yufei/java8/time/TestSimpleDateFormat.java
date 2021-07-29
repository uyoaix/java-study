package com.study.yufei.java8.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 解决DateFormat 多线程不安全问题
 *
 * @author yufei.wang
 * @date 2021/07/29 10:23
 */
public class TestSimpleDateFormat {

    private static final int EXECUTE_COUNT = 1000;

    private static final int THREAD_COUNT = 20;

    private static ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) throws InterruptedException {

        final Semaphore semaphore = new Semaphore(THREAD_COUNT);
        final CountDownLatch countDownLatch = new CountDownLatch(EXECUTE_COUNT);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < EXECUTE_COUNT; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    try {
                        dateFormatThreadLocal.get().parse("2021-08-01");
                    } catch (NumberFormatException | ParseException e) {
                        System.out.println("线程:" + Thread.currentThread().getName() + " 格式化日期失败");
                        e.printStackTrace();
                        System.exit(1);
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    System.out.println("信号量发生错误");
                    e.printStackTrace();
                    System.exit(1);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println("所有线程格式化日期成功");

    }
}
