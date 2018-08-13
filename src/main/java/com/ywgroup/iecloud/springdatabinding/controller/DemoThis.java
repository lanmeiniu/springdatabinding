package com.ywgroup.iecloud.springdatabinding.controller;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description this关键字的概述和应用
 * <p>
 * this 关键字的特点
 * 代表当前对象的引用
 *
 * 用来区分局部变量和成员变量
 * 在成员变量前加this this 代表当前对象的引用
 * @date 2018/07/20 13:59
 */
public class DemoThis {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(120);
        person.setName("张三");
        System.out.println("person = [" + person.getName() + person.getAge() + "]");

    }

    static class Person {
        private String name;

        private int age;


        public void setAge(int age) {
            if (age > 0 && age < 200) {
                this.age = age;
            } else {
                System.out.println("年龄格式不符合规范");
            }

        }

        public int getAge() {
            return age;
        }

        public void setName (String name) {
            if (StringUtils.isBlank(name)) {
                System.out.println("name 不能为空");
            } else {
                 this.name = name;
            }
        }

        public String getName () {
            return name;
        }

    }


}
