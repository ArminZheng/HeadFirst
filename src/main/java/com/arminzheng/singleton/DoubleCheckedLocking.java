package com.arminzheng.singleton;

/**
 * Double-Checked-Locking
 *
 * @author zy
 * @version 2022/3/22
 */
public class DoubleCheckedLocking {

    /*
     volatile 的原因：禁止指令重排序
      new SomeObject() equals:
        1 memory = allocate()
        2 ctorInstance(memory)
        3 instance = memory
      2、3步可能出现重排序，也就是分配好空间后，直接将对象指向还未实例化的地址，导致其他对象判断不为空，拿到对象进行操作就会报错。
  （还有解决可见性的作用）
      多个线程将同一个数据读取到各自的缓存区后，某个cpu修改了缓存的数据之后，会立马同步给主存，volatile就是这么实现可见性的

      May, 7 2022 new: 分配好内存空间后，初始化对象 和 指向刚分配的内存空间 容易乱序
        导致：指向内存空间后，导致B以为拿到初始化后的对象，使用时导致空指针异常
        修复：通过 volatile 关键字，指令重排序被禁止，就让B知道访问的是一个初始化未完成的对象。
        @ volatile屏蔽指令重排序的语义在JDK1.5中才被完全修复，仍然不能完全避免重排序，JDK1.5之前的Java中无法安全地使用DCL。
     */
    private volatile static DoubleCheckedLocking uniqueInstance;
    public String here;

    /**
     * 双重检查锁的原因：只加一层会导致每次进来都加锁，而实际上只在第一次初始化的时候才需要用到，之后的调用都没必要再进行加锁。
     */
    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        // 双重检查加锁
        if (uniqueInstance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DoubleCheckedLocking();
                }
            }
        }
        return uniqueInstance;
        // 除此之外，还有eagerly实例化和使用同步的getInstance
    }

    public static void main(String[] args) {
        DoubleCheckedLocking instance = DoubleCheckedLocking.getInstance();
        instance.boil();
        DoubleCheckedLocking instanceI = DoubleCheckedLocking.getInstance();
        DoubleCheckedLocking instanceII = DoubleCheckedLocking.getInstance();
        instanceI.boil();
        instanceII.boil();

        instance.here = "stock fish";
        instanceI.boil();
        instanceII.boil();
        DoubleCheckedLocking instanceIII = DoubleCheckedLocking.getInstance();
        instanceIII.boil();
    }

    public void boil() {
        System.out.println("is boil: " + here);
    }
}
