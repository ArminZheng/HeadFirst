package com.arminzheng.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS: Producer Extends Consumer Super
 *
 * @author zy
 * @version 2022/5/4
 */
public class PECSTest {

    /**
     * 根据 PECS 写出来的代码，保证了编译时代码安全，并使得调用方传参空间变得更大
     * Kotlin 的 in 和 out 相对 extends 和 super就直观很多
     * in 只能进和 out 只能出
     */
    @Test
    public void generic() {
        ArrayList<Object> objects;
        ArrayList<String> strings = new ArrayList<>();
        // objects = strings;

        // extends协变，放宽对子类型的约束，协变只能取；作为生产者可以使用 extends out producer
        List<? extends Number> list1 = new ArrayList<Double>(){{ add(101.0);}};
        // list1.add(1.0);
        Number number = list1.get(0); // 把子类取出来当父类使用，而不知道具体类型    （用）
        System.out.println("number = " + number);

        // super逆变，放宽对父类型的约束，逆变只能存；作为消费者 super in consumer
        List<? super Double> list2 = new ArrayList<Number>(){{add(1); add(1.2);}};

        list2.add(1.0);
        System.out.println("list2 = " + list2);
        Object object = list2.get(1); // 把父类当做子类用，但只能用父类方法，且取出来是对象      （用）
        System.out.println("object = " + object);
        System.out.println("object instanceof Double = " + (object instanceof Double));
        System.out.println("object instanceof Number = " + (object instanceof Number));
        System.out.println("object instanceof Integer = " + (object instanceof Integer));
        Double value = (Double) list2.get(1);
        System.out.println("value = " + value);
    }
}
