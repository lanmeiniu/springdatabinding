package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/07/31 10:08
 */
public class EqualMethod {

    public static void main(String[] args) {
        // 新建实例
        EqualMethod equalMethod = new EqualMethod();
        int result = equalMethod.test();
        System.out.println("result = [" + result + "]");

    }

    /**
     * 创建变量 divider 除数
     * result 结果
     * try-catch捕获while循环
     * 每次循环 divider减一，result = result +1
     * 如果捕获异常打印
     * 否则返回result
     * @return
     */
    public int test () {
        int divider = 10;
        int result = 100;
        try {
            while (divider > -1) {
                divider --;
                result = result +100/divider;
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常");
            return  -1;
        }
    }
}
