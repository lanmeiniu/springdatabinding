package com.ywgroup.iecloud.concurrency;

/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/28 10:25
 * @version V1.0.0
 * Description 对象锁实例1 代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable{
    /**
     * 创建实例
     */
    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    /**
     * 定义锁对象
     */
    Object lock = new Object();
    Object lock2 = new Object();



    public static void main(String[] args) throws InterruptedException {
        // 静态方法 必须用static关键字
        Thread thread = new Thread(instance);
        Thread thread2 = new Thread(instance);
        // 启动线程
        thread.start();
        thread2.start();
        while (thread.isAlive() || thread2.isAlive()) {

        }



    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是lock对象锁的代码块形式,我叫"+ Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock运行结束"+ Thread.currentThread().getName());
        }
//        synchronized (lock2) {
//            System.out.println("我是lock2对象锁的代码块形式,我叫"+ Thread.currentThread().getName());
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("lock2运行结束"+ Thread.currentThread().getName());
//        }
//
    }
}
