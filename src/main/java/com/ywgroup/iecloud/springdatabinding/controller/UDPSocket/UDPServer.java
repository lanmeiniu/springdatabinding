package com.ywgroup.iecloud.springdatabinding.controller.UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 服务器端，实现基于UDP的用户登录
 * @date 2018/08/07 19:13
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        // 创建服务器端DatagramSocket 指定端口
        DatagramSocket datagramSocket = new DatagramSocket(8800);
        // 创建数据报 用于接收客户端发送的数据
        // 创建字节数组，指定接收的数据包的大小
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
        // 接收客户端发送的数据 将它保存在datagramPacket的数据报中
        System.out.println("服务器端已经启动，等待客户端");
        // 调用receive 方法的时候 会出现阻塞的方法
        datagramSocket.receive(datagramPacket);
        // 读取数据
        String info = new String (data, 0,datagramPacket.getLength());

        System.out.println("我是服务器，客户端说 = [" + info + "]");

        /**
         * 向客户端响应数据
         */
        // 定义客户端的地址、端口号、数据
        InetAddress inetAddress = datagramPacket.getAddress();
        int port = datagramPacket.getPort();
        byte[] dataClient = "欢迎您！".getBytes();
        // 创建数据报，包含响应的数据信息
        DatagramPacket datagramPacket1 = new DatagramPacket(dataClient,dataClient.length,inetAddress,port);
        // 响应客户端
        datagramSocket.send(datagramPacket1);
        datagramSocket.close();
    }

}
