package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 构造器的概述与格式
 * @date 2018/07/21 15:06
 */
public class DemoConstructor {
    /**
     * 构造方法的概述和作用
     * 构造方法不能用对象调用，因为在创建对象时就已经调用了构造方法
     *  给对象的数据（属性）进行初始化
     * 构造的格式特点
     *
     *   类名与方法名相同
     *   没有返回值类型，不是void
     *   没有返回值
     * @param args
     */

    public static void main(String[] args) {
        Person person = new Person();
        person.show();
    }

    static class Person {
        private String name;
        private Integer age;

        public Person () {
//            System.out.println("person的构造器调用了");
            name = "张三";
            age = 5;
        }
        public void show () {
            System.out.println("name" + name + "age" + age);
        }
    }
}
