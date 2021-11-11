package com.study.yufei.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出 分析内存快照
 *
 * @author yufei.wang
 * @date 2021/10/22 14:59
 */
public class Demo12 {

    public static void main(String[] args) {
        long counter = 0;
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
            System.out.println("添加了" + (++counter) + "个对象");
        }
    }
}
