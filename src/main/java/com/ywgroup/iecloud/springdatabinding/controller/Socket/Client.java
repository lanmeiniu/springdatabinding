package com.ywgroup.iecloud.springdatabinding.controller.Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 客户端向 服务器端的通信
 * @date 2018/08/06 17:54
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 创建socket 指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            // 获取输出流，向服务端发送信息
            OutputStream outputStream = socket.getOutputStream();
            // 将输出流包装为打印流
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：admin;密码：123456");
            // 刷新缓存
            printWriter.flush();
            // 关闭输出流
            socket.shutdownOutput();
            // 客户端获取输入流 并读取服务器端的响应信息
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info ;
            //  循环读取服务端信息
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是客户端，服务器端说 = [" + info + "]");

            }

            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



