package com.study.yufei.thread;

/**
 * @author yufei.wang
 * @date 2022/3/3 16:08
 */
public class MyRunnableTest implements Runnable{


    @Override
    public void run() {
        while (true){
            getThreadName();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getThreadName(){
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        //new Thread(new MyRunnableTest()).start();

        Runnable runnableTask = () ->{
            while (true){
                getThreadName();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnableTask).start();

        while (true){
            getThreadName();
            Thread.sleep(2000);
        }
    }
}
