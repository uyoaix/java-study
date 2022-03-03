package com.study.yufei.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author yufei.wang
 * @date 2022/3/3 16:26
 */
public class MyThreadPoolTest {

    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("TestThreadPool-%d").build();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,
                10,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());

        while (true){
            poolExecutor.execute(() ->{
                System.out.println("当前线程名：" + Thread.currentThread().getName());
            });
        }


    }
}
