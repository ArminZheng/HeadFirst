package com.arminzheng.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * OptimismAndPessimism
 *
 * @author armin
 * @version 2021/12/14
 */
public class OptimismAndPessimism {

    // Pessimism：适合写操作多的场景，认为一定会被修改，所以在获取数据的时候会先加锁，确保不会被别的线程修改；
    public synchronized void m1(){
        // 加锁后的逻辑
    }
    // 保证多个线程使用的是同一个lock对象的前提下
    ReentrantLock lock = new ReentrantLock();
    public void m2(){
        lock.lock();
        try {
            // 操作同步资源
        } finally {
            lock.unlock();
        }
    }

    // Optimism：适合读操作多的场景，乐观锁认为自己在使用数据时不会有别的线程修改数据，所以不会添加锁，只是在更新数据的时候去判断之前有没有别的线程更新了这个数据
    // 最常采用CAS算法，java 原子类中的递增操作就是通过CAS自旋实现的；
    // 保证多个线程使用的是同一个AtomicInteger
    public void m3(){
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }
}
