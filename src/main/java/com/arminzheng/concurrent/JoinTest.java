package com.arminzheng.concurrent;

/**
 * 合并线程，合并到主线程，此线程执行完以后，再进行下面的操作。其他线程阻塞。
 *
 * @author armin
 * @version 2021/12/10
 */
public class JoinTest implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        // 合并
        Thread thread = new Thread(new JoinTest());
        thread.start();
        // thread线程已经在执行了
        for (int i = 0; i < 1000; i++) {
            if (i == 900)
                // 这时thread插队到主线程Main中，Main只能等thread执行完。
                thread.join();
            System.out.println(Thread.currentThread().getName() + "正在执行..." + i + "次");
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "在执行中...");
    }
}