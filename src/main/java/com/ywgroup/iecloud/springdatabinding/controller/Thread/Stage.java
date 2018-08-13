package com.ywgroup.iecloud.springdatabinding.controller.Thread;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 隋唐演义的大戏舞台
 * @date 2018/08/10 08:30
 */
public class Stage extends Thread {
    @Override
    public void run() {

        System.out.println("欢迎观看隋唐演义");
        // 让观众们安静片刻
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋朝末年，隋军与农民起义军开启了战争……");

        // 引入军队
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        // 农民军的作战
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        // 线程创建有四种方法，其中 Thread(Runnable target,String name)
        // 创建军队线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        // 创建农民军线程
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");
        // 启动线程，两个军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();
        // 舞台线程休眠 50ms
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣，半路杀出个程咬金");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想就是结束战争，使百姓安居乐业");

        // 让两个军队 停止作战，鸣金收兵
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 留给关键人物
         */
        mrCheng.start();
        // 万众瞩目，所有线程等待程咬金完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束~~");

    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
