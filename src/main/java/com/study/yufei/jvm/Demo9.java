package com.study.yufei.jvm;

/**
 * 模拟栈内存溢出
 *
 * @author yufei.wang
 * @date 2021/10/22 10:42
 */
public class Demo9 {

    public static long counter = 0;

    public static void main(String[] args) {
        work();
    }

    public static void work(){
        System.out.println("第 " + (++counter) + "次调用方法");
        work();
    }
}
