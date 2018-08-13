package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 构造方法的重载即注意事项
 * @date 2018/07/21 15:19
 */
public class DemoReload {
    /**
     * 什么是重载？
     * 重载：方法名相同，与返回值类型无关（且构造方法没有返回值），只看参数列表
     * <p>
     * 若没有给出构造方法，系统会给出默认的空参的构造
     * 反之，则要自己给出无参构造
     */
    public static void main(String[] args) {
        System.out.println("Hello world");
        Person person = new Person();
        person.show();
        Person person1 = new Person("张珊", 22);
        person1.show();
    }

    static class Person {
        private String name;
        private int age;

        public Person() {
            System.out.println("空参数的构造");
        }

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
            System.out.println("name = [" + name + "], age = [" + age + "]" + "有参的构造");
        }

        public void show() {
            System.out.println("name = [" + name + "], age = [" + age + "]");
        }
    }
}
