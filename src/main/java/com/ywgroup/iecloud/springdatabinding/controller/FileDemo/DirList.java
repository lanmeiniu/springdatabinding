package com.ywgroup.iecloud.springdatabinding.controller.FileDemo;

import java.io.File;
import java.util.Arrays;


/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/08/06 19:46
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");

        String[] list ;

        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println("dirItem = [" + dirItem + "]");
        }
    }


}

