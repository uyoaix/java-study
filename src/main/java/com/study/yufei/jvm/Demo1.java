package com.study.yufei.jvm;

/**
 * @author yufei.wang
 * @date 2021/10/11 16:56
 */
public class Demo1 {

    public static void main(String[] args) {

        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;


        byte[] array2 = new byte[2 * 1024 * 1024];
    }
}
