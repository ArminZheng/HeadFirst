package com.arminzheng.generic;

import java.util.ArrayList;
import java.util.List;

interface Filter<E> {
    boolean test(E element);
}

/**
 * Super
 *
 * @author zy
 * @version 2022/5/4
 */
public class Super {

    public static <E> List<E> removeIf(List<E> list, Filter<? super E> filter) {
        List<E> removeList = new ArrayList<>();
        for (E e : list) {
            // 逆变能进行操作 <? super Short> <? super Double>
            if (filter.test(e)) {
                removeList.add(e);
            }
        }
        list.removeAll(removeList);
        return list;
    }
    public static List<Double> removeDoubleIf(List<Double> list, Filter<? super Double> filter) {
        List<Double> removeList = new ArrayList<>();
        for (Double e : list) {
            // 逆变规定：只能传入 Double。在里面调用的是 通用(父类)方法，哪怕传入的是子类。
            if (filter.test(e)) {
                // Super：本质是父类，限定了子类，适合限定消费子类的父类。
                removeList.add(e);
            }
        }
        list.removeAll(removeList);
        return list;
    }

    public static void main(String[] args) {
        List<Short> shortList = new ArrayList<Short>() {{
            add((short) 99);
            add((short) 101);
            add((short) 200);
            add((short) 89);
        }};
        List<Double> doubleList = new ArrayList<Double>() {{
            add(99d);
            add(101d);
            add(200d);
            add(89d);
        }};
        // Number 类型可以认为是 ? super Short 的子类，所以可以传过去（让父类适应子类，但只能用父类方法）

        /* Double e; ? super Double filter
        if (filter.test(e)) {
            removeList.add(e);
        }
        */
        Filter<Number> numberFilter = element -> element.doubleValue() > 100;

        List<Short> shorts = removeIf(shortList, numberFilter); // E == Short
        List<Double> doubles = removeIf(doubleList, numberFilter); // E == Double
        System.out.println("shorts = " + shorts);
        System.out.println("doubles = " + doubles);

        Integer x = 1;
        Number y = x;
        Node<? super Double> z = new Node<>(y);
        System.out.println("z.t instanceof Double = " + (z.t instanceof Double));
        System.out.println("z.t instanceof Number = " + (z.t instanceof Number));
        System.out.println("z.t instanceof Integer = " + (z.t instanceof Integer));
    }
}

class Node<T> {
    T t;

    public Node(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}