package com.ywgroup.iecloud.springdatabinding.controller.MultithReadingSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 基于TCP协议的实现多线程的socket通信 服务器端
 * @date 2018/08/06 17:54
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try {
            // 创建服务器端的socket 即ServerSocket 绑定指定端口并且监听
            // 1023之前端口已经默认分配给通用的服务
            // 创建ServerSocket的实例
            ServerSocket serverSocket = new ServerSocket(8888);
            // 调用accept（）方法监听，等待客户端连接
            System.out.println("服务器即将启动，等待客户端的连接");
            Socket socket = null;
            // 记录客户端的数量
            int count = 0;

            // 循环监听等待客户端的连接

            while (true) {

                socket = serverSocket.accept();
                // 创建新的线程，与客户端进行通信
                ServerThread serverThread = new ServerThread(socket);
                // 启动线程
                serverThread.start();

                count++;
                System.out.println("客户端的数量："+count);

                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
