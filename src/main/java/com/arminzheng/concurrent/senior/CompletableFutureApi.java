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
            // ApiIII();
            ApiIIII();
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
     *
     * exceptionally -> try/catch
     * whenComplete + handle -> try/finally
     * 光秃秃的，和+Async的区别：+Async是把这个任务继续提交给线程池新增一个来执行；而光秃秃是当前线程继续执行。
     */
    public static void ApiI() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }, threadPoolExecutor);
        // System.out.println(future.get());
        // System.out.println(future.get(2L,TimeUnit.SECONDS)); // 过时不候，会抛 TimeoutException 异常
        // System.out.println(future.getNow(9999)); // 给一个默认值，不抛异常
        // System.out.println(future.join()); // 和get一样，但不会抛异常
        System.out.println("打断是否成功：" + future.complete(8888) + "\t返回结果为" + future.get()); // 主动触发计算，返回是否打断
        threadPoolExecutor.shutdown();
    }

    /**
     * 3. 对计算结果进行消费
     * thenAccept  void (in)
     * thenRun void ()
     * thenApply out (in)
     */
    public static void ApiIII() {
        CompletableFuture.supplyAsync(() -> {
                    return 1;
                })
                .thenApply((f) -> f + 2)
                .thenApply((f) -> f + 3)
                .thenAccept(f -> System.out.println(f));
    }

    /**
     * 4. 速度优选 applyToEither 和
     * 对计算结果进行合并 thenCombine (聚合多个中台服务合并数据：调用两个第三方接口，合并2个接口的内容返回给前端)
     */
    public static void ApiIIII() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        System.out.println(
                CompletableFuture.supplyAsync(() -> {
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "first");
                            return 1;
                        }, threadPoolExecutor)
                        // 速度优选
                        .applyToEither(CompletableFuture.supplyAsync(() -> {
                                    try {
                                        TimeUnit.SECONDS.sleep(5);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println(Thread.currentThread().getName() + "second");
                                    return 2;
                                }, threadPoolExecutor)
                                , r -> {
                                    System.out.println(Thread.currentThread().getName() + "third");
                                    return r;
                                })
                        .join());

        System.out.println(CompletableFuture.supplyAsync(() -> {
                    return 10;
                    // 对计算结果进行合并
                }).thenCombine(CompletableFuture.supplyAsync(() -> {
                            System.out.println(Thread.currentThread().getName() + "combine");
                            return 20;
                        }, threadPoolExecutor),
                        (r1, r2) -> {
                            return r1 + r2;
                        })
                .join());

        threadPoolExecutor.shutdown();
    }

}
