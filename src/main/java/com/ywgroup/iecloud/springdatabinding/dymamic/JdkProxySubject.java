package com.ywgroup.iecloud.springdatabinding.dymamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description aop的aspect
 * 动态代理类
 * @date 2018/09/20 14:26
 */
public class JdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行动态代理的逻辑
        System.out.println("before");
        Object result = null;
        try{
            result = method.invoke(realSubject,args);

        }catch (Exception e) {

            System.out.println("Exception" + e.getMessage());
            throw e;

        } finally {
            System.out.println("after");

        }

        return result;
    }
}
