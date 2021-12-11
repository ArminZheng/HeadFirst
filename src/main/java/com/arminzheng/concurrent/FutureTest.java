package com.arminzheng.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Future
 *
 * @author armin
 * @version 2021/12/10
 */
public class FutureTest implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "执行完了");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTest future1 = new FutureTest();
        FutureTest future2 = new FutureTest();
        FutureTest future3 = new FutureTest();
        // 执行 Callable 方法有 4 个步骤

        // 1、创建执行任务(Executors and ExecutorService)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2、提交执行
        Future<Boolean> submit1 = executorService.submit(future1);
        Future<Boolean> submit2 = executorService.submit(future2);
        Future<Boolean> submit3 = executorService.submit(future3);

        // 3、获取结果
        Boolean b1 = submit1.get();
        Boolean b2 = submit2.get();
        Boolean b3 = submit3.get();
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);

        // 4、关闭服务
        executorService.shutdown();

        // other
        FutureTask<Boolean> task = new FutureTask<>(new FutureTest());
        new Thread(task, "futureTask").start();
        Boolean a = task.get();
        System.out.println("a = " + a);
    }
}
