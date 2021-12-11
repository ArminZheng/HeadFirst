package com.arminzheng.concurrent;

import java.util.function.Consumer;

/**
 * LambdaTest
 *
 * @author armin
 * @version 2021/12/10
 */
public class LambdaTest {
    public static void main(String[] args) {
        A a;
        a = System.out::print;
        a.a("hhhhh");
        a = LambdaTest::toSchool;
        B<LambdaTest> b;
        b = LambdaTest::new;

    }
    public static void toSchool(String a) {
        System.out.println(a + "要去学校了！");
    }
}
interface A{
    void a(String a);
}
interface B<T>{
    T b();
}