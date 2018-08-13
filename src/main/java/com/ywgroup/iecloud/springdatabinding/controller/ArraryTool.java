package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description description
 * @date 2018/07/23 08:58
 */
public class ArraryTool {
    /**
     * 1.获取最大值
     * 2.数组的遍历
     * 3.数组的反转
     */

    public  int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1;i < arr.length ; i++) {
            if (max < arr [i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public void print (int[] arr) {
        for (int i = 0 ; i<arr.length ; i++) {
            System.out.println("arr = [" + arr[i] + "]");
        }
    }

    public void revArray(int[] arr) {
        for (int i = 0; i < arr.length/2 ; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}
