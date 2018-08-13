package com.ywgroup.iecloud.springdatabinding.controller.FileDemo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/08/07 13:21
 */
public class IOUtil {
    /**
     * 读取指定文件内容，按照16进制输出到控制台
     *
     * 并且每输出10个byte换行
     */
    public static void printHex(String fileName) throws IOException {
        // 把文件作为字节流进行读操作
        FileInputStream inputStream = new FileInputStream(fileName);
        //
        int b;
        int i = 1;
        while ((b = inputStream.read()) != -1) {
            // 将整数b转换为16进制表示的字符串
            System.out.println(Integer.toHexString(b)+ " ");
            if (i ++ % 10 == 0) {
                // 换行
                System.out.println();
            }
        }
        inputStream.close();
    }
}
