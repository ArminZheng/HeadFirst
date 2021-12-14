package com.arminzheng.concurrent.senior;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zy
 * @version 2021/12/13
 */
public class CompletableFutureApi {

    public static void main(String[] args) {
        try {
            ApiII();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对计算结果进行处理
     */
    public static void ApiII() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    return 1;
                }, threadPoolExecutor)
                .thenApply(f -> f + 1)
                .thenApply(f -> f + 2)
                .whenComplete((v, e) -> {
                    if (e == null) {
                        System.out.println("result: " + v);
                    }
                }).exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
        System.out.println(future.join());
        threadPoolExecutor.shutdown();
    }

    /**
     * 获得结果和触发计算
     */
    public static void ApiI() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
            return 1;
        }, threadPoolExecutor);
        // System.out.println(future.get());
        // System.out.println(future.get(2L,TimeUnit.SECONDS)); // 过时不候，会抛 TimeoutException 异常
        // System.out.println(future.getNow(9999)); // 给一个默认值，不抛异常
        // System.out.println(future.join()); // 和get一样，但不会抛异常
        System.out.println("打断是否成功：" + future.complete(8888) + "\t返回结果为" + future.get()); // 主动触发计算，返回是否打断
        threadPoolExecutor.shutdown();
    }
}
