package com.study.yufei.design.pattern.command;

/**
 * @author yufei.wang
 * @date 2020/12/04 19:43
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl(){}

    public void setSlot(Command command){
        this.slot = command;
    }

    public void buttonPressed(){
        slot.execcute();;
    }
}
