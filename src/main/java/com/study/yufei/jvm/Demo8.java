package com.study.yufei.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 模拟MetaSpace内存溢出
 *
 * @author yufei.wang
 * @date 2021/10/21 20:56
 */
public class Demo8 {

    public static void main(String[] args) {

        long counter = 0;
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                if (method.getName().equals("run")) {
                    System.out.println("启动汽车前，先进行自动的安全检查。。。");
                }
                return methodProxy.invokeSuper(o, objects);
            });
            Car car = (Car) enhancer.create();
            car.run();
            System.out.println("目前创建了" + (++counter) + "个Car类的子类");
        }

    }

    static class Car {
        public void run() {
            System.out.println("汽车启动，开始行驶。。。");
        }
    }
}
