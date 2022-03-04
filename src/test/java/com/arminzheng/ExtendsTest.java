package com.arminzheng;

/**
 * @author Armin Zheng
 * @since 2021-08-24
 */
public class ExtendsTest {

    public static void main(String[] args) {
        Child child = new Child();
        child.show();
        child.init();
        System.out.println("child.a = " + child.a);
        System.out.printf("xxx: %.3fs\n", new Object[]{Double.valueOf(12.20)});
        System.out.printf("xxx: %.3fs, %.6fs\n", new Object[]{Double.valueOf(12.20),Double.valueOf(12.20)});
        System.out.printf("xxx: %.3fs, %.3fs\n", Double.valueOf(12.20),Double.valueOf(12.20));
    }
}

class Parent {
    public int a;

    public void show() {
        System.out.println(this.getClass().getName());
        System.out.println(super.getClass().getName());
        // 全都"该对象的运行时类"
    }

    public void add() {
        this.a++;
        System.out.println("baba: a = " + a);
    }

    @Override
    public String toString() {
        return "com.arminzheng.Parent{" +
                "a=" + a +
                '}';
    }
}

class Child extends Parent {
    public int a = 1024;

    public void show() {
        // getClass()是在Object上声明的final方法。 getClass具有说明文件“返回此对象的运行时类”
        System.out.println(super.getClass().getName());
        super.show();
    }

    void init() {
        this.add();
        add();
        super.add();
        System.out.println("son: a = " + a);
        System.out.println("super.a = " + super.a);
    }
}