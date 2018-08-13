package com.ywgroup.iecloud.springdatabinding.controller;

import java.util.Random;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 我们的小确幸
 * @date 2018/08/12 12:57
 */
public class OurStory {
    /**
     * time
     */
    private static final int MAX_YEAR = 10000;
    /**
     * hu's Unique coding
     */
    private static Integer hu = 5;
    /**
     * ni's Unique coding
     */
    private static Integer ni = 2;
    /**
     * hz's Unique coding
     */
    private static Integer hz = 0;

    public static void main(String[] args) throws InterruptedException {
        // 时间轴 一年年的循环
        for (int i = 0; i < MAX_YEAR; i++) {
            // 茫茫人海的男孩子中
            Random boys = new Random();
            // 茫茫人海的女孩子中
            Random girls = new Random();
            // 中国万千地点
            Random locations = new Random();
            // 在大千世界,男孩叫hu 女孩叫ni 地点在hz 姓氏的缩写H&Z
            if (boys.nextInt(10) == hu) {
                System.out.println("I'm hu , I'm looking for my girl");
                if (girls.nextInt(10) == ni) {
                    System.out.println("200 status ok ! Server connection address is correct! :)");
                    if (locations.nextInt(10) == hz) {
                        System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                        System.out.println("hi,my girl,welcome to my life");
                        System.out.println("****************hu❤ni IN hz*****************************");
                        System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
                        // 陪伴是最长情的告白，我们的❤上锁,Long 型的最长时间
                        Thread.sleep(Long.MAX_VALUE);
                    } else {
                        System.out.println("hi,girl!nice to meet you ! let's start with friends :>");
                        continue;
                    }
                } else {
                    System.out.println("404 NOT FOUND ! Server connection address is wrong :(");
                    continue;
                }
            }
        }
    }
}

