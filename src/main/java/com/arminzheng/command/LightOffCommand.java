package com.arminzheng.command;

import com.arminzheng.command.item.Light;

/**
 * LightOnCommand
 *
 * @author zy
 * @version 2022/3/25
 */
public class LightOffCommand implements Command {

    Light light;

    /**
     * Command的子类都组合了对应的功能对象，并组装编排对应的命令成一个execute
     *
     * @param light 组合的功能对象
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        System.out.println(">>>>>>caution! undoing...");
        light.on();
        System.out.println("<<<<<<undo done");
    }
}
