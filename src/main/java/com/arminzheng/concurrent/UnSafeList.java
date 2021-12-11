package com.arminzheng.concurrent;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Vector;

/**
 * UnsafeList
 *
 * @author armin
 * @version 2021/12/11
 */
public class UnSafeList {

    public static void main(String[] args) {
        // Vector<String> list = new Vector<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (list) { // 锁住变化的部分
                    list.add(Thread.currentThread().getName());
                }
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
