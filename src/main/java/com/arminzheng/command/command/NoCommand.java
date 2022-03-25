package com.arminzheng.command.command;

/**
 * NoCommand
 *
 * @author zy
 * @version 2022/3/25
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("no command execute");
    }

    @Override
    public void undo() {
        System.out.println("no command undo");
    }
}
