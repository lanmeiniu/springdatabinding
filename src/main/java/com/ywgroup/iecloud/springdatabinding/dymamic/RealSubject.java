package com.ywgroup.iecloud.springdatabinding.dymamic;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 目标对象
 * @date 2018/09/20 14:29
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real subject execute request");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
