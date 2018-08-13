package com.ywgroup.iecloud.springdatabinding.controller;

import com.ywgroup.iecloud.springdatabinding.reflect.User;

import java.beans.PropertyEditorSupport;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 数据绑定
 * @date 2018/07/23 10:02
 */
public class MyPropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User();
        String [] textArray = text.split(",");
        user.setUsername(textArray[0]);
        user.setAge(Integer.parseInt(textArray[1]));
        System.out.println("user = [" + user + "]");
        this.setValue(user);
    }

    public static void main(String[] args) {
        MyPropertyEditor myPropertyEditor = new MyPropertyEditor();
        myPropertyEditor.setAsText("tom,22");

        System.out.println("myPropertyEditor.getValue(); = [" + myPropertyEditor.getValue().toString() + "]");

    }
}
