package com.arminzheng.command.remote;

import com.arminzheng.command.Command;
import com.arminzheng.command.GarageDoorOpenCommand;
import com.arminzheng.command.LightOffCommand;
import com.arminzheng.command.LightOnCommand;
import com.arminzheng.command.NoCommand;
import com.arminzheng.command.item.GarageDoor;
import com.arminzheng.command.item.Light;

/**
 * SimpleRemoteControl
 *
 * @author zy
 * @version 2022/3/25
 */
public class RemoteControlWithUndo {

    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    public static void main(String[] args) {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();
        Light light = new Light("Studio");
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(1, lightOn, lightOff);

        remote.offButtonWasPressed(0);
        remote.onButtonWasPressed(0);
        remote.undoButtonWasPressed();

        remote.offButtonWasPressed(1);
        remote.undoButtonWasPressed();
    }
}
