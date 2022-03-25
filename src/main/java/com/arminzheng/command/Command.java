package com.arminzheng.command;

/**
 * Command
 *
 * @author zy
 * @version 2022/3/25
 */
public interface Command {

    void execute();

    void undo();
}
