package com.arminzheng.concurrent;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * SafeList
 *
 * @author armin
 * @version 2021/12/11
 */
public class SafeList {
    public static void main(String[] args) {

        // Vector<String> list = new Vector<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 不安全的list 会有不同的name添加到同一个位置，最后的size 可能不为1000
        System.out.println(list.size());
    }
}
