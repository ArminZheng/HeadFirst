package com.arminzheng.concurrent.senior;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * CompletableFutureNetMall
 *
 * @author armin
 * @version 2021/12/12
 */
public class CompletableFutureNetMall {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("taobao"),
            new NetMall("dangdang"),
            new NetMall("tmall"),
            new NetMall("pdd"));

    public static List<String> getPriceByStep(List<NetMall> list, String productName) {
        return list.stream().map(
                        f -> String.format(productName + " in %s price is %.2f", f.getMallName(), f.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    public static List<String> getPriceByAsync(List<NetMall> list, String productName) {
        // 挨个调度，变成了异步编排
        return list.stream().map(
                        f -> CompletableFuture.supplyAsync(
                                () -> String.format(productName + " in %s price is %.2f", f.getMallName(), f.calcPrice(productName)))).collect(Collectors.toList())
                .stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> mysql = getPriceByStep(list, "mysql");
        mysql.forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.println("--costTime: " + (endTime - startTime) + " 毫秒");

        long startTime2 = System.currentTimeMillis();
        List<String> java = getPriceByAsync(list, "java");
        java.forEach(System.out::println);
        long endTime2 = System.currentTimeMillis();
        System.out.println("--costTime: " + (endTime2 - startTime2) + " 毫秒");
    }
}

class NetMall {
    @Getter
    private final String mallName;

    public NetMall(String mallName) {
        this.mallName = mallName;
    }

    public double calcPrice(String productName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}