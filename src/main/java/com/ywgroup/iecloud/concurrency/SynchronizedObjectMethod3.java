package com.ywgroup.iecloud.concurrency;

/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/28 11:17
 * @version V1.0.0
 * Description  对象锁实例2 方法锁形式
 */
public class SynchronizedObjectMethod3 implements Runnable{
    /**
     * 创建实例
     */
    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();




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
        // 调用这个方法
        method();

    }

    public synchronized void method () {
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("运行结束" + Thread.currentThread().getName());

    }

}
