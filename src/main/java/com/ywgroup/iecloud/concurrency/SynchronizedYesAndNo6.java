package com.ywgroup.iecloud.concurrency;

/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/28 15:32
 * @version V1.0.0
 * Description 同时访问同步方法和非同步方法
 */
public class SynchronizedYesAndNo6 implements Runnable {

    static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();


    @Override
    public void run() {
        // 访问两种方法
        if (Thread.currentThread().getName().equals("Thread-0")) {
             method1();
        } else {
            method2();
        }

    }

    public synchronized void method1() {
        System.out.println("我是同步方法的线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法的运行结束" + Thread.currentThread().getName());
    }

    public void method2() {
        System.out.println("我是非同步方法的线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("非同步方法的运行结束" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // 静态方法 必须用static关键字
        Thread thread = new Thread(instance);
        Thread thread2 = new Thread(instance);
        // 启动线程
        thread.start();
        thread2.start();
    }
}
