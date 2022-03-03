package com.study.yufei.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yufei.wang
 * @date 2022/3/3 16:15
 */
public class MyTimerThreadTest {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName());
            }
        }, new Date(), 2000);
    }
}
