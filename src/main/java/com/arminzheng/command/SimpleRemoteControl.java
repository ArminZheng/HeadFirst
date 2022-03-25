package com.arminzheng.command;

import com.arminzheng.command.command.Command;
import com.arminzheng.command.command.GarageDoorOpenCommand;
import com.arminzheng.command.command.LightOnCommand;
import com.arminzheng.command.item.GarageDoor;
import com.arminzheng.command.item.Light;

/**
 * SimpleRemoteControl
 *
 * @author zy
 * @version 2022/3/25
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {
    }

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("Living Room");
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOpen);
        remote.buttonWasPressed();
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

    public void undoButtonWasPressed() {
        slot.undo();
    }
}
