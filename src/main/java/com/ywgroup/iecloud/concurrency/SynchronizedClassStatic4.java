package com.ywgroup.iecloud.concurrency;

/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/28 14:13
 * @version V1.0.0
 * Description 类锁的第一种形式 synchronized加在static上
 */
public class SynchronizedClassStatic4 implements Runnable{

    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();

    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我是类锁的第一种形式,我叫"+ Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束"+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // 静态方法 必须用static关键字
        Thread thread = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        // 启动线程
        thread.start();
        thread2.start();
        while (thread.isAlive() || thread2.isAlive()) {

        }
    }

}
