package com.arminzheng.singleton;

/**
 * 延迟初始化占位类
 *
 * @author zy
 * @version 2022/3/22
 */
public class StaticNested {

    public static class StaticNestedHolder {
        // JVM将推迟内部类的初始化操作，直到开始使用这个类时才初始化
        public static final StaticNested INSTANCE = new StaticNested();
    }

    private StaticNested() {
    }

    public static StaticNested getInstance() {
        return StaticNestedHolder.INSTANCE;
    }

    public void dumb() {
        System.out.println("dumb dumb");
    }
}
