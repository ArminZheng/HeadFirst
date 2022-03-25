package com.arminzheng.command;

import com.arminzheng.command.item.GarageDoor;

/**
 * GarageDoorOpenCommand
 *
 * @author zy
 * @version 2022/3/25
 */
public class GarageDoorOpenCommand implements Command {

    GarageDoor garageDoor;

    /**
     * Command的子类都组合了对应的功能对象，并组装编排对应的命令成一个execute
     *
     * @param garageDoor 组合的功能对象
     */
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
