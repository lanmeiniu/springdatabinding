package com.ywgroup.iecloud.springdatabinding.controller;

import com.ywgroup.iecloud.springdatabinding.pojo.po.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/08/05 16:20
 */
public class ListTest {

    /**
     * 备选课程
     */
    public List coursesToSelective;

    /**
     * 添加构造方法
     */
    public ListTest () {
        /**
         * list是一个接口,不能直接实例化(用类创建对象的过程称为实例化)
         */
        this.coursesToSelective = new ArrayList();

    }

    /**
     * 用于coursesToSelective 添加备选课程
     */
    public void testAdd () {
        /**
         * 课程对象的实例
         */
        Course course = new Course("1","数据结构");
        /**
         * 添加到list中
         */
        coursesToSelective.add(course);

        Course course1 = (Course)coursesToSelective.get(0);

        System.out.println("course1" + course1.id + ";" + course1.name);
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();

        listTest.testAdd();
    }
}
