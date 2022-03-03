package com.study.yufei.thread;

/**
 * @author yufei.wang
 * @date 2022/3/3 15:57
 */
public class MyThreadTest extends Thread{

    public MyThreadTest(){
        //this.setName("Thread线程测试");
    }

    @Override
    public void run() {
        while (true){
            getThreadName();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadTest myThreadTest = new MyThreadTest();
        myThreadTest.start();

        while (true){
            getThreadName();
            Thread.sleep(1000);
        }
    }

    public static void getThreadName(){
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }
}
