package com.arminzheng.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * SeniorLock
 *
 * @author armin
 * @version 2021/12/11
 */
public class SeniorLock implements Runnable {

    public static void main(String[] args) {
        SeniorLock problem = new SeniorLock();
        new Thread(problem, "小明").start();
        new Thread(problem, "老师").start();
        new Thread(problem, "黄牛").start();
    }

    private int tickNum = 10;
    boolean flag = true;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    // 同步方法，锁的是this
    public void buy() {
        try {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            if (tickNum <= 0) {
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t拿到了第" + tickNum-- + "张票！");
        } finally {
            lock.unlock();
        }
    }
}
