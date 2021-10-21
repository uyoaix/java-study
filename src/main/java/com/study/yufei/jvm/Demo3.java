package com.study.yufei.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行代码，dump内存快照
 * 分析内存泄漏
 *
 * @author yufei.wang
 * @date 2021/10/21 10:35
 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Data());
        }

        Thread.sleep(60 * 60 * 1000);

    }

    static class Data {

    }
}
