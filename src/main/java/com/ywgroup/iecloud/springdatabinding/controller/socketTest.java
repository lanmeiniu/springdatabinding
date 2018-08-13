package com.ywgroup.iecloud.springdatabinding.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description InetAddress类
 * @date 2018/08/06 16:27
 */
public class socketTest {

    public static void main(String[] args) throws UnknownHostException {
        // 获取本机的InetAddress实例

        InetAddress inetAddress = InetAddress.getLocalHost();

        System.out.println("获取此 IP 地址的主机名 = [" + inetAddress.getHostName() + "]");
        System.out.println("返回 IP 地址字符串（以文本表现形式） = [" + inetAddress.getHostAddress() + "]");
        System.out.println("获取此 IP 地址的完全限定域名 = [" + inetAddress.getCanonicalHostName() + "]");
        // 获取字节形式的ip地址
        System.out.println("返回此 InetAddress 对象的原始 IP 地址 = [" + inetAddress.getAddress() + "]");
        // 获取字节形式的ip地址
        System.out.println("返回此 InetAddress 对象的原始 IP 地址 = [" + Arrays.toString(inetAddress.getAddress()) + "]");
        System.out.println("args = [" + inetAddress + "]");
    }
}
