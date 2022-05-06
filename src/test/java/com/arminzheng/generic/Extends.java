package com.arminzheng.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Extends
 *
 * @author zy
 * @version 2022/5/4
 */
public class Extends {

    public static double sum(List<? extends Number> list) {
        // 由于变广了，任何子类都能使用，且里面已经有值了，就不能随便添加
        // list.add((Number) 5.0d);
        double result = 0;
        for (Number number : list) {
            result += number.doubleValue();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        double sum = sum(doubles);
        System.out.println("doubles.getClass().getGenericSuperclass() = " + doubles.getClass().getGenericSuperclass());
        System.out.println("doubles.getClass().getGenericInterfaces() = " + doubles.getClass().getGenericInterfaces());
    }
}
