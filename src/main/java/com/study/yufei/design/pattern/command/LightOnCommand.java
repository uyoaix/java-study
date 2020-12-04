package com.study.yufei.design.pattern.command;

/**
 * @author yufei.wang
 * @date 2020/12/04 19:39
 */
public class LightOnCommand implements Command{

    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execcute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
