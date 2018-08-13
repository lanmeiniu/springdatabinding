package com.ywgroup.iecloud.springdatabinding.pojo.po;


import java.util.HashSet;
import java.util.Set;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 学生类
 * @date 2018/08/05 16:14
 */

public class Student {
    public  String id;

    public String name;

    /**
     * 课程信息的属性
     */
    public Set courses;
    public Student (String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet();
    }
}
