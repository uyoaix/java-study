package com.study.test;

/**
 * @author yufei.wang
 * @date 2021/11/15 19:36
 */
public class TestCloneable implements Cloneable{

    public static void main(String[] args) {

        TestCloneable testCloneable = new TestCloneable();
        System.out.printf("instance = " + (testCloneable instanceof  Cloneable));
    }
}
