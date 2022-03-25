package com.arminzheng.command.item;

/**
 * Light
 *
 * @author zy
 * @version 2022/3/25
 */
public class Light {

    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "Light On");
    }

    public void off() {
        System.out.println(name + "Light Off");
    }
}
