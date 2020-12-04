package com.study.yufei.design.pattern.command;

/**
 * @author yufei.wang
 * @date 2020/12/04 19:45
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        simpleRemoteControl.setSlot(lightOnCommand);
        simpleRemoteControl.buttonPressed();

        simpleRemoteControl.setSlot(garageDoorOpenCommand);
        simpleRemoteControl.buttonPressed();
    }
}
