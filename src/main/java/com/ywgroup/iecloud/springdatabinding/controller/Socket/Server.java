package com.ywgroup.iecloud.springdatabinding.controller.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 基于TCP协议的socket通信 服务端
 * @date 2018/08/06 17:54
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // 创建服务器端的socket 即ServerSocket 绑定指定端口并且监听
        // 1023之前端口已经默认分配给通用的服务
        // 创建ServerSocket的实例
        ServerSocket serverSocket = new ServerSocket(8888);
        // 调用accept（）方法监听，等待客户端连接
        System.out.println("服务器即将启动，等待客户端的连接");
        Socket socket = serverSocket.accept();
        // 实现数据交互，获取客户端提交的数据信息，获取字节输入流
        InputStream inputStream = socket.getInputStream();
        // 将字节流转为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 为输入流添加缓冲
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String info ;
        //  循环读取客户端信息
        while ((info = bufferedReader.readLine()) != null) {
            System.out.println("我是服务器,客户端说 = [" + info + "]");

        }
        // 关闭输入流
        socket.shutdownInput();
        // 获取输出流，用来响应客户端的请求
        OutputStream outputStream = socket.getOutputStream();
        // 包装为打印流
        PrintWriter printWriter = new PrintWriter(outputStream);
        // 响应客户端的请求
        printWriter.write("欢迎您！~~");
        // 调用flush()方法将缓冲输出
        printWriter.flush();
        // 关闭资源
        printWriter.close();
        outputStream.close();

        bufferedReader.close();
        // 关闭inputStream
        inputStream.close();
        // 关闭inputStreamReader
        inputStreamReader.close();
        // 关闭 serverSocket
        serverSocket.close();


    }
}
