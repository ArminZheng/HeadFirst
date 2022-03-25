package com.arminzheng.command;

import com.arminzheng.command.command.Command;
import com.arminzheng.command.command.GarageDoorOpenCommand;
import com.arminzheng.command.command.LightOffCommand;
import com.arminzheng.command.command.LightOnCommand;
import com.arminzheng.command.command.NoCommand;
import com.arminzheng.command.item.GarageDoor;
import com.arminzheng.command.item.Light;

/**
 * SimpleRemoteControl
 *
 * @author zy
 * @version 2022/3/25
 */
public class RemoteControl {

    private final Command[] onCommands;
    private final Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light("Kitchen");
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(1, lightOn, lightOff);
        remote.offButtonWasPressed(0);
        remote.onButtonWasPressed(0);
        remote.offButtonWasPressed(1);
        remote.onButtonWasPressed(1);
        // remote.setCommand(garageDoorOpen);
        // remote.buttonWasPressed();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
    }
}
