package com.ywgroup.iecloud.springdatabinding.controller.FileDemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/08/06 19:54
 */
public class DirFilter implements FilenameFilter {


        private Pattern pattern;

        public DirFilter(String regex) {
            pattern = Pattern.compile(regex);
        }
        @Override
        public boolean accept (File dir, String name) {
            return pattern.matcher(name).matches();
        }

    public static void main(String[] args) {

        String[] list = {"a","c","b"};
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list) {
            System.out.println("dirItem = [" + dirItem + "]");
        }
    }
    }
