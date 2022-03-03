package com.study.yufei.thread;

/**
 * @author yufei.wang
 * @date 2022/3/3 16:04
 */
public class MutipleThreadTest extends Thread{

    public MutipleThreadTest(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        while (true){
            getThreadName();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getThreadName(){
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        new MutipleThreadTest("线程1").start();
        new MutipleThreadTest("线程2").start();;

        while (true){
            getThreadName();
            Thread.sleep(5000);
        }
    }
}
