package com.arminzheng.observer;

/**
 * @author Armin Zheng
 * @since 2021-05-12
 */
public interface Subject {

    public void registerObserver(Observer o); // 都需要一个观察者作为变量

    public void removeObserver(Observer o); // 都需要一个观察者作为变量

    public void notifyObserver(); // 当主题状态改变时，这个方法会被调用，已通知所有观察者

}
