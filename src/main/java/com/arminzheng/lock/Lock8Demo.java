package com.arminzheng.lock;

import java.util.concurrent.TimeUnit;

/**
 * 8种锁
 *
 * @author yZheng
 * @version 2021/12/17
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone.sendEmail();
        }, "t1").start();
        try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        // new Thread(()->{
        //     phone.sendSMS();
        // }, "t2").start();
        new Thread(()->{
            phone.sendHello();
        }, "t3").start();
        new Thread(()->{
            phone2.sendSMS();
        }, "t4").start();
    }
}
class Phone {

    public static synchronized void sendEmail() {
        try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("========= sendEmail");
    }

    public static synchronized void sendSMS(){
        System.out.println("========= sendSMS");
    }

    public void sendHello(){
        System.out.println("========= sendHello");
    }
}
