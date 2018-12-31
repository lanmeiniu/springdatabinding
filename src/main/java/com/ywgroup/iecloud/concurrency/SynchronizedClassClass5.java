package com.ywgroup.iecloud.concurrency;



/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/28 14:25
 * @version V1.0.0
 * Description 类锁的第二种形式 synchronized（。*class）代码块
 */
public class SynchronizedClassClass5 implements Runnable{

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();

    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    @Override
    public void run() {
        method();
    }

    // 用类修饰的锁对象
    private void method() {

        synchronized (SynchronizedClassClass5.class){
            System.out.println("我是类锁的第二种形式synchronized (.*class)" + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("运行结束"+ Thread.currentThread().getName());

        }
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

        System.out.println("args = + wancheng");
    }

}
