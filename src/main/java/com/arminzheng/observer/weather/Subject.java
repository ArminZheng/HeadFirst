package com.arminzheng.observer.weather;

/**
 * @author Armin Zheng
 * @since 2021-05-12
 */
public interface Subject {

    /**
     * registerObserver
     *
     * @param o 需要一个观察者作为变量
     * @author Armin Zheng
     * @since 2021-05-13
     */
    public void registerObserver(Observer o); //

    /**
     * removeObserver
     *
     * @param o 需要一个观察者作为变量
     * @author Armin Zheng
     * @since 2021-05-13
     */
    public void removeObserver(Observer o);

    /**
     * 当主题状态改变时，这个方法会被调用，已通知所有观察者
     *
     * @author Armin Zheng
     * @since 2021-05-13
     */
    public void notifyObserver();

}
