package com.study.yufei.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yufei.wang
 * @date 2022/3/3 16:16
 */
public class MyCallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> Thread.currentThread().getName();

        FutureTask<String> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        String threadName = futureTask.get();
        System.out.println(threadName);
    }

}
