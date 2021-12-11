import java.util.stream.Stream;

/**
 * @author Armin Zheng
 * @since 2021-09-04
 */
public class Synchronization {

    public static Integer n = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> Stream.iterate(0, i -> i + 1).limit(100000).forEach(i -> n++);

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("当前线程："+ Thread.currentThread().getName());
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        // t1.start();t1.join();  // 其实就是顺序执行
        // t2.start();t2.join();
        // t3.start();t3.join();
        // t4.start();t4.join();
        // Thread.sleep(1000);
        System.out.println("n = " + n);
        System.out.println("当前线程："+ Thread.currentThread().getName());
    }
}
