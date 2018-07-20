package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/07/19 15:27
 */
public class DemoCar {

    public static void main(String[] args) {
        // 创建对象
        Car car = new Car();
        // 调用属性并赋值
        car.color = "red";
        car.number = 8;

        // 调用行为
        car.run();

    }

    /**
     * 车的属性
     *      车的颜色
     *      车的轮胎数
     * 车的行为
     *     车运行
     */
    static class Car {
        String color;
        int number;

        public void run () {
            System.out.println(color + "......" + number);
        }
    }
}
