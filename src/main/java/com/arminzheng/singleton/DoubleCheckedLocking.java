package com.arminzheng.singleton;

/**
 * Double-Checked-Locking
 *
 * @author zy
 * @version 2022/3/22
 */
public class DoubleCheckedLocking {

    private volatile static DoubleCheckedLocking uniqueInstance;
    /*
     volatile 的原因：禁止指令重排序
      new SomeObject() equals:
        1 memory = allocate()
        2 ctorInstance(memory)
        3 instance = memory
      2、3步可能出现重排序，也就是分配好空间后，直接将对象指向还未实例化的地址，导致其他对象判断不为空，拿到对象进行操作就会报错。
  （还有解决可见性的作用）
      多个线程将同一个数据读取到各自的缓存区后，某个cpu修改了缓存的数据之后，会立马同步给主存，volatile就是这么实现可见性的
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

    public String here;

    public void boil() {
        System.out.println("is boil" + here);
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
    }
}
