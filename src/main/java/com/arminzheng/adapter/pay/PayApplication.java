package com.arminzheng.adapter.pay;

public class PayApplication {

    public static void main(String[] args) {
        WechatPay wechatPay = new WechatPay();
        Pay payWay = new WechatPayAdapter(wechatPay);
        boolean pay = payWay.pay();
        System.out.println("pay = " + pay);
    }
}