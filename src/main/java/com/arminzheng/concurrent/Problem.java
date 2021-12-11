package com.arminzheng.concurrent;

/**
 * 使用并发带来的问题
 *
 * @author armin
 * @version 2021/12/10
 */
public class Problem implements Runnable {

    private int tickNum = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    // 同步方法，锁的是this
    public synchronized void buy() {
        if (tickNum <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t拿到了第" + tickNum-- + "张票！");
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        new Thread(problem, "小明").start();
        new Thread(problem, "老师").start();
        new Thread(problem, "黄牛").start();
    }
}
