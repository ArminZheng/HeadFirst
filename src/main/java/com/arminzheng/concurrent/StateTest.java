package com.arminzheng.concurrent;

/**
 * StateTest
 *
 * @author armin
 * @version 2021/12/11
 */
public class StateTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("<<<<<<<<<<<<<<");
        });

        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();

        while (state != Thread.State.TERMINATED){
            state = thread.getState();
            System.out.println(state);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Bilibili {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("This is " + i + Thread.currentThread().isDaemon());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        new Thread(runnable).start();
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState());
    }
}
