package com.study.yufei.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yufei.wang
 * @date 2020/12/11 20:18
 */
public class Test1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        StringBuffer sb = new StringBuffer();
        list.forEach(integer -> sb.append(integer).append(","));

        System.out.println(sb);

        String string = sb.toString();
        String[] split = string.split(",");

        System.out.println();
    }

    public static class Model {
        private int id;

        private int value;

        public Model(){}
        public Model(int id, int value){
            this.id = id;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
