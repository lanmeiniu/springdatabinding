package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/07/20 08:17
 */

/**
 * 匿名对象的使用
 * 匿名对象只适合用在对方法的一次调用的地方
 *
 */
public class Demo2Car {
    public static void main(String[] args) {
        new Car().color = "red";
        new Car().num = 8;
        new Car().run();
    }

    static class Car {
        String color;
        int num;

        public void run () {
            System.out.println(color + "……" + num );
        }
    }
}
