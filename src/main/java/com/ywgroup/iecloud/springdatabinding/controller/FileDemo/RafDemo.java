package com.ywgroup.iecloud.springdatabinding.controller.FileDemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description RandomAccessFile的demo
 * @date 2018/08/07 08:28
 */
public class RafDemo {

    public static void main(String[] args) throws IOException{

        /**
         * 如果没有写绝对路径，那么就是此项目的相对路径
         */
        File file = new File("demo");
        if (!file.exists()) {
            // 创建文件夹
            file.mkdir();
        }
        // 以file作为父目录，创建一个.dat文件
        File file1 = new File(file,"raf,dat");
        if (!file1.exists()) {
            // 创建文件
            file1.createNewFile();
        }

        RandomAccessFile accessFile = new RandomAccessFile(file1,"rw");
        // 指针的位置
        System.out.println("accessFile.getFilePointer() = [" + accessFile.getFilePointer() + "]");
        // 只写了一个字节,并非是char，是后8位
        accessFile.write('A');
        // 指针的位置
        System.out.println("accessFile.getFilePointer() = [" + accessFile.getFilePointer() + "]");

        int i = 0x7fffffff;
        // 用write方法每次只能写一个字节，如果要把i写进去，得写四次
        accessFile.write(i >>> 24);
        accessFile.write(i >>> 16);
        accessFile.write(i >>> 8);
        accessFile.write(i );

        // 可以直接用writeInt
        accessFile.writeInt(i);

        // 中文
        String s = "中国";
        byte[] gbk = s.getBytes("gbk");
        accessFile.write(gbk);
        System.out.println("accessFile.getFilePointer() = [" + accessFile.length() + "]");

        // 读文件，将指针移动头部
        accessFile.seek(0);
        // 一次性读取
        byte[] bytes = new byte[(int) accessFile.length()];
        accessFile.read(bytes);
        System.out.println("args = [" + Arrays.toString(bytes) + "]");

        accessFile.close();
    }
}
