package com.arminzheng.concurrent;

/**
 * DeadLock
 *
 * @author armin
 * @version 2021/12/11
 */
public class DeadLock {
    public static void main(String[] args) {
        new MakeUp("美女1",1).start();
        new MakeUp("美女2",2).start();
    }
}
class LipStick{
}
class Mirror{}
class MakeUp extends Thread{

    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();
    int choice;

    public MakeUp(String name, int choice) {
        super(name);
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws InterruptedException {
        if (choice == 1){
            synchronized (lipStick){
                System.out.println(getName() + "开始涂口红");
                Thread.sleep(100);
                // 占用着口红，不释放又继续开始拿镜子
                synchronized (mirror){
                    System.out.println(getName() + "开始照镜子");
                }
            }
        }else if (choice == 2){
            synchronized (mirror){
                System.out.println(getName() + "开始照镜子");
                Thread.sleep(100);
                // 占用着镜子，不释放又继续开始拿口红
                synchronized (lipStick){
                    System.out.println(getName() + "开始涂口红");
                }
            }
        }
    }
}