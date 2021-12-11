package com.arminzheng.concurrent;

/**
 * Monitors
 *
 * @author armin
 * @version 2021/12/11
 */
public class Monitors {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Producer(synContainer).start();
        new Consumer(synContainer).start();

    }
}

class Producer extends Thread {
    SynContainer synContainer;

    public Producer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("生产了第" + i + "只鸡");
            synContainer.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("<<<<<<<<<<<<消费了第" + synContainer.pop().id + "只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    Chicken[] ck = new Chicken[10];
    // 当前总数
    int count = 0;

    public synchronized void push(Chicken chicken) {
        if (count == ck.length) {
            // 当前总数达到数组容量
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ck[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            // 当前总数为0，没有内容了
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = ck[count];
        this.notifyAll();
        return chicken;
    }
}
