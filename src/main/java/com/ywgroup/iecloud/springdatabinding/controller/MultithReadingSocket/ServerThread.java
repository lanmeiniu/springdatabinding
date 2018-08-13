package com.ywgroup.iecloud.springdatabinding.controller.MultithReadingSocket;

import java.io.*;
import java.net.Socket;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 服务器端线程处理类
 * @date 2018/08/06 19:07
 */
public class ServerThread extends Thread {

    /**
     * 每个线程都有对应的与本线程相关的socket
     */
    Socket socket = null;

    /**
     * 初始化socket 用构造方法进行初始化
     * @param socket
     */
    public ServerThread (Socket socket) {
        // 每当创建 ServerThread 实例的时候，就会调用带参的构造方法
        // 初始化和本线程相关的socket
        this.socket = socket;
    }

    /**
     * 线程执行的操作，来响应客户端的请求
     */
    @Override
    public void run () {

        InputStream inputStream =null;
        InputStreamReader inputStreamReader =null;
        BufferedReader bufferedReader =null;
        OutputStream outputStream =null;
        PrintWriter printWriter =null;

        try {
            // 实现数据交互，获取客户端提交的数据信息，获取字节输入流
            inputStream = socket.getInputStream();
            // 将字节流转为字符流
            inputStreamReader = new InputStreamReader(inputStream);
            // 为输入流添加缓冲
            bufferedReader = new BufferedReader(inputStreamReader);

            String info ;
            //  循环读取客户端信息
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务器,客户端说 = [" + info + "]");

            }
            // 关闭输入流
            socket.shutdownInput();
            // 获取输出流，用来响应客户端的请求
            outputStream = socket.getOutputStream();
            // 包装为打印流
            printWriter = new PrintWriter(outputStream);
            // 响应客户端的请求
            printWriter.write("欢迎您！~~");
            // 调用flush()方法将缓冲输出
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(printWriter!=null) {
                    printWriter.close();
                }

                if(outputStream!=null){
                    outputStream.close();
                }

                if(bufferedReader!=null) {
                    bufferedReader.close();
                }
                if(inputStreamReader!=null) {
                    inputStreamReader.close();
                }
                if(inputStream!=null) {
                    inputStream.close();
                }
                if(socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
