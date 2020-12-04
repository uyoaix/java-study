package com.study.yufei.design.pattern.command;

/**
 * @author yufei.wang
 * @date 2020/12/04 19:50
 */
public class GarageDoorOpenCommand implements Command{

    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execcute() {
        garageDoor.up();
    }

    @Override
    public void undo(){
        garageDoor.down();
    }
}
