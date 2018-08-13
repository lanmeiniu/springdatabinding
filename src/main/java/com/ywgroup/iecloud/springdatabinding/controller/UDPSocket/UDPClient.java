package com.ywgroup.iecloud.springdatabinding.controller.UDPSocket;

import java.io.IOException;
import java.net.*;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 客户端
 * @date 2018/08/07 19:13
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {
        // 向服务器端发送数据
        // 定义服务器的地址、端口号、数据
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 8800;
        // 将 string转为byte字节
        byte[] data = "用户名：admin；密码：123456".getBytes();
        // 创建datagramPacket 数据报,包含发送的数据信息
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,port);
        // 创建datagramSocket 实现数据的发送
        DatagramSocket datagramSocket = new DatagramSocket();
        // 使用 datagramSocket 发送数据报
        datagramSocket.send(datagramPacket);

        // 接收服务器端响应的数据
        // 接收响应的数据 创建数据报
        byte[] dataServer = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(dataServer,dataServer.length);
        // 接收服务器响应的数据
        datagramSocket.receive(datagramPacket1);
        // 读取数据
        String reply = new String(dataServer,0,datagramPacket1.getLength());
        System.out.println("我是客户端，服务器端说 = [" + reply + "]");
        datagramSocket.close();

    }
}
