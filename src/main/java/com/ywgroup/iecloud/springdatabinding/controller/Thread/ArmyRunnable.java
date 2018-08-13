package com.ywgroup.iecloud.springdatabinding.controller.Thread;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 军队线程，模拟作战双方的行为
 * @date 2018/08/10 08:13
 */
public class ArmyRunnable implements Runnable{

    /**
     * java 关键字 保证了线程可以正确读取其他线程写入的值
     */
    volatile boolean keepRunning;
    @Override
    public void run() {
        while (keepRunning) {

            // 发动5连击
            for (int i = 0 ; i < 5 ; i ++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方" + i + "次");

                // 当前运行线程释放处理器资源
                Thread.yield();
            }

        }

        System.out.println(Thread.currentThread().getName() + "进攻结束");

    }
}
