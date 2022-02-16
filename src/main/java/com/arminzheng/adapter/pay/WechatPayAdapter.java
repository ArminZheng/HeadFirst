package com.arminzheng.adapter.pay;

public class WechatPayAdapter implements Pay {

    WechatPay wechatPay;

    public WechatPayAdapter(WechatPay wechatPay) {
        this.wechatPay = wechatPay;
    }

    public boolean pay(){
        return wechatPay.payCash();
    }
}
