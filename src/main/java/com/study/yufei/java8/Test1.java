package com.study.yufei.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yufei.wang
 * @date 2020/12/11 20:18
 */
public class Test1 {

    public static void main(String[] args) {

        List<Model> models = new ArrayList<>();
        models.add(new Model(1,333));
        models.add(new Model(2, 4444));

        Map<Integer, Model> modelMap = models.stream().collect(Collectors.toMap(Model::getId, Function.identity(), (m1, m2) -> m2));

        System.out.println(modelMap.containsKey(1));

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
