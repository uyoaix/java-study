package com.study.yufei.design.pattern.factory;

/**
 * 披萨类
 *
 * @author yufei.wang
 * @date 2020/12/04 10:00
 */
public interface Pizza {

    /**
     * 准备
     */
    void prepare();

    /**
     * 烘焙
     */
    void bake();

    /**
     * 切片
     */
    void cut();

    /**
     * 装盒
     */
    void box();

}
