package com.arminzheng.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantDemo
 *
 * @author zy
 * @version 2021/12/21
 */
public class ReentrantDemo {

    static final Object object = new Object();

    public static void main(String[] args) {
        // syncBlock();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "====外层");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "\t" + "====内层");
                } finally {
                    lock.unlock();
                }

            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "====外层");
            lock.unlock();
        }, "t2").start();
    }

    private static void syncBlock() {
        new Thread(() -> {
            synchronized (object) {
                System.out.println("外部");
                synchronized (object) {
                    System.out.println("中部");
                    synchronized (object) {
                        System.out.println("内部");
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1").start();
        new Thread(() -> {
            System.out.println("hhhh");
        }, "t2").start();
    }
}
