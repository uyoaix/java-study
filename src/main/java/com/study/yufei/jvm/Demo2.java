package com.study.yufei.jvm;

/**
 * @author yufei.wang
 * @date 2021/10/11 17:45
 */
public class Demo2 {

    public static void main(String[] args) {

        // 第一步 触发Young GC
        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[128 * 1024];

        byte[] array3 = new byte[2 * 1024 * 1024];

        // 第二步 第二次 Yong GC ， 存活对象进入老年代
        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[128 * 1024];
        array3 = null;

        byte[] array4 = new byte[2 * 1024 * 1024];

    }
}
