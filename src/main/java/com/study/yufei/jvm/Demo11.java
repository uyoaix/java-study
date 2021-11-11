package com.study.yufei.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Metaspace 内存溢出，打出日志
 *
 * @author yufei.wang
 * @date 2021/10/22 14:40
 */
public class Demo11 {

    public static void main(String[] args) {
        long counter = 0;

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                if(method.getName().equals("run")){
                    System.out.println("启动汽车之前，进行安全检查");
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
            System.out.println("汽车启动， 开始行驶。。。");
        }
    }

}
