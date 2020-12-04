package com.study.yufei.design.pattern.command;

/**
 * @author yufei.wang
 * @date 2020/12/04 20:34
 */
public class LightOffCommand implements Command{

    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execcute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
