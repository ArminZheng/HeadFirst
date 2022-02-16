package com.arminzheng.adapter;

import com.arminzheng.strategy.Duck;

public class TurkeyAdapter extends Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    protected void display() {
        System.out.println("this is Turkey");
    }

    @Override
    public void performQuack() {
        turkey.gobble();
    }

    @Override
    public void performFly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
