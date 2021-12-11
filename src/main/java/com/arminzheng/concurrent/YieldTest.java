package com.arminzheng.concurrent;

/**
 * TestYield
 *
 * @author armin
 * @version 2021/12/10
 */
public class YieldTest  implements Runnable{
    public static void main(String[] args) {
        YieldTest myYield = new YieldTest();
        new Thread(myYield,"礼让线程1").start();
        new Thread(myYield,"礼让线程2").start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我要开始了");
        // 线程礼让
        Thread.yield(); // 让线程暂停一下，提示当前线程愿意放弃其当前对处理器的使用，不阻塞。是否让由cpu决定
        System.out.println(Thread.currentThread().getName() + "我要结束了");
    }
}