package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/07/19 19:19
 */

/**
 * 在类中的位置不同
 * 成员变量： 在类中方法外
 * 局部变量： 在方法定义中或者方法声明上
 * 在内存中的位置不同
 * 成员变量： 在堆的内存 （成员变量属于对象，对象进堆内存）
 * 局部变量： 在栈的内存 （局部变量属于方法，方法进栈内存）
 * 生命周期不同
 * 成员变量：随着对象的创建而存在，随着对象的消失而消失
 * 局部变量：随着方法的调用而存在，随着方法的调用完毕而消失
 *
 *初始化值不同
 * 成员变量：有默认初始化值
 * 局部变量：没有默认初始化值,必须定义，赋值,然后才能使用
 *
 * 注意事项：
 * 局部变量名称可以和成员变量名称一样，在方法中使用的时候，采用就近原则，
 * 因为这两个存在的地址不一样。成员变量为对象，对象存储在堆中，而局部变量为方法内，存储在栈中
 * 基本数据类型变量包括：byte short int long float double boolean char
 * 引用数据类型变量包括：数组、类、接口、枚举
 */

public class DemoPerson {
    public static void main(String[] args) {
        System.out.println("Hello World ！");
        Person person = new Person();
        person.speak();
    }


    static class Person {
        /**
         * 成员变量
         */
        String name ;

        public void speak () {
            /**
             * x为方法声明之上，number 为方法定义中 所以都为局部变量
             */
            int number = 10;

            System.out.println("name = [" + name + "]");

            System.out.println("number = [" + number + "]");
        }
    }
}
