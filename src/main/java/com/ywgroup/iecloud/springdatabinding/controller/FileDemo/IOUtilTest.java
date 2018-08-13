package com.ywgroup.iecloud.springdatabinding.controller.FileDemo;

import java.io.IOException;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/08/07 13:29
 */
public class IOUtilTest {

    public static void main(String[] args) {
        try {
            IOUtil.printHex("E:\\assetmanagement\\pom.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
