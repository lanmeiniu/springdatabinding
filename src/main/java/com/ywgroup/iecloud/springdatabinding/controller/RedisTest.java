package com.ywgroup.iecloud.springdatabinding.controller;

import redis.clients.jedis.Jedis;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/08/12 15:37
 */
public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.auth("123456");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
