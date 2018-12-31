package com.ywgroup.iecloud.concurrency;

/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/28 16:22
 * @version V1.0.0
 * Description 方法抛异常后，会释放锁
 * 展示不抛出异常前和抛出异常后的对比：
 * 一旦抛出了异常,第二个线程会like进入同步方法，意味着锁已经释放
 */
public class SynchronizedException9 implements Runnable{
    static SynchronizedException9 instance = new SynchronizedException9();
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

        System.out.println("我是静态加锁的方法,我叫"+ Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
            // 主动抛异常
            throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception ec) {
            ec.printStackTrace();
        }
        System.out.println("运行结束"+ Thread.currentThread().getName());
    }

    public synchronized void method2() {

        System.out.println("我是静态加锁的方法,我叫"+ Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束"+ Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        // 静态方法 必须用static关键字
        Thread thread = new Thread(instance);
        Thread thread2 = new Thread(instance);
        // 启动线程
        thread.start();
        thread2.start();
        while (thread.isAlive() || thread2.isAlive()) {

        }

        System.out.println("args = + wancheng");
    }

}
