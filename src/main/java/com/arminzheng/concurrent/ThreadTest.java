package com.arminzheng.concurrent;

/**
 * @author Armin Zheng
 * @since 2021-05-26
 */
public class ThreadTest {
    static int cnt = 0;  //共享数据cnt

    public static void main(String[] args) {

        new Thread(new Runnable() { // 匿名对象：Runnable
            public void run() {
                System.out.println("Runnable's run method is running");
            }
        }) { // 匿名对象：Thread
            @Override
            public void run() {
                System.out.println("Thread's run method is running");
            }
        }.start();

        new Thread() { // 匿名对象：Thread
            @Override
            public void run() {
                System.out.println("The code waiting for Thread1");
            }
        }.start();

        // new Thread(() -> System.out.println("The code waiting for Thread2")).start();
        new Thread(new Runnable() { // 匿名对象：Runnable
            @Override
            public void run() {
                System.out.println("The code waiting for Thread2");
            }
        }).start();

        Runnable r = new Runnable() { // 接口对象：创建对象是为了能共享资源
            @Override
            public void run() {
                System.out.println("The code waiting for Threads~");
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Runnable r1 = new Runnable() {
            @Override
            public synchronized void run() {
                //有多条语句操作共享数据
                int n = 10000;
                while (n > 0) {
                    cnt++;
                    n--;
                }
            }
        };
        //多线程环境
        Thread tt1 = new Thread(r);
        Thread tt2 = new Thread(r);
        Thread tt3 = new Thread(r);
        Thread tt4 = new Thread(r);
        Thread tt5 = new Thread(r);
        tt1.start();
        tt2.start();
        tt3.start();
        tt4.start();
        tt5.start();

        try {
            //等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cnt);
    }
    /*
    出现问题的原因在于cnt++并不是原子性操作，实际上分三步：
        1.各个线程从主存拷贝变量
        2.在自己的工作内存进行+1操作
        3.把结果回写到主存
    */

}
