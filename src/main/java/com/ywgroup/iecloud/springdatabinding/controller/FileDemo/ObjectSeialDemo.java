package com.ywgroup.iecloud.springdatabinding.controller.FileDemo;

import java.io.*;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 对象序列化
 * @date 2018/08/07 13:48
 */
public class ObjectSeialDemo {

    public static void main(String[] args) {
        String file = "demo/obj.dat";
        // 对象序列化 写的操作
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            Student student = new Student("1001","张三",20);
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化 读的操作
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                Student student = (Student) objectInputStream.readObject();
                System.out.println("args = [" + student + "]");
                objectInputStream.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
