package com.arminzheng.concurrent.senior;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureDemo
 *
 * @author armin
 * @version 2021/12/11
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                20,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // demo1(threadPoolExecutor);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1024;
        }, threadPoolExecutor).thenApply(f -> {
            return ++f;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("the result is " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        System.out.println("Main 正在继续");

        threadPoolExecutor.shutdown();
    }

    private static void demo1(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName() + " come in!"));

        System.out.println(voidCompletableFuture.get());
        CompletableFuture<Void> voidCompletableFuture2 =
                CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName() + " come in!"), threadPoolExecutor);

        System.out.println(voidCompletableFuture2.get());

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in!");
            return 1024;
        });
        System.out.println("integerCompletableFuture.get() = " + integerCompletableFuture.get());

        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in!");
            return 1024;
        }, threadPoolExecutor);
        System.out.println("integerCompletableFuture2.get() = " + integerCompletableFuture2.get());
    }
}
