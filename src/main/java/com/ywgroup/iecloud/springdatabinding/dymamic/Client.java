package com.ywgroup.iecloud.springdatabinding.dymamic;

import java.lang.reflect.Proxy;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/09/20 14:59
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[] {Subject.class}, new JdkProxySubject(new RealSubject()));

        subject.hello();
    }
}
