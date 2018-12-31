package com.ywgroup.iecloud.concurrency;

/**
 * @author lanmeiniu@outlook.com
 * date 2018/12/27 20:00
 * @version V1.0.0
 * Description 消失的请求数
 */
public class DisappearRequest1 implements Runnable{

    /**
     * 创建实例
     */
    static DisappearRequest1 instance = new DisappearRequest1();

    Object object = new Object();

    static int i = 0;


    public static void main(String[] args) throws InterruptedException {
        // 静态方法 必须用static关键字
        Thread thread = new Thread(instance);
        Thread thread2 = new Thread(instance);
        // 启动线程
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        // 输出结果
        System.out.println("args = [" + i + "]");


    }

    @Override
    public  void run() {

        synchronized (DisappearRequest1.class) {
            for (int j = 0;j < 100000000 ;j++) {
                i++;
            }
        }

    }
}
