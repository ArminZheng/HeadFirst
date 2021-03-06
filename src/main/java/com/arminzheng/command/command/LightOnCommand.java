package com.arminzheng.command.command;

import com.arminzheng.command.item.Light;

/**
 * LightOnCommand
 *
 * @author zy
 * @version 2022/3/25
 */
public class LightOnCommand implements Command {

    Light light;

    /**
     * Command的子类都组合了对应的功能对象，并组装编排对应的命令成一个execute
     *
     * @param light 组合的功能对象
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        System.out.println(">>>>>>caution! undoing...");
        light.off();
        System.out.println("<<<<<<undo done");
    }
}
