package com.ywgroup.iecloud.springdatabinding.controller;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 长方形案例练习
 * @date 2018/07/21 15:58
 */
public class DemoRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHigh(20);
        System.out.println("rectangle = [" + rectangle.getArea() + "]");
        System.out.println("^---------------------------");
        System.out.println("rectangle = [" + rectangle.getLength() + "]");

    }

    /**
     * 1.成员变量
     * 宽 width   高 high
     * 2.空参、有参的构造
     * 3.成员的方法
     *
     * setXXX()
     * getXXX()
     * 求周长：getLength()
     * 求面积: getArea()
     */
    static class Rectangle {
        /**
         * 宽 width
         */
        private int width;
        /**
         * 高 high
         */
        private int high;

        /**
         * 空参构造
         */
        public Rectangle () {}
        /**
         * 有参构造
         */
        public Rectangle(int width, int high){
            this.high = high;
            this.width = width;
        }
        /**
         * 成员方法
         */
        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        public void setHigh(int high) {
            this.high = high;
        }
        public int getHigh() {
            return high;
        }

        public int getLength () {

            return 2*(width+width);
        }

        public int getArea () {

            return width*width;
        }
    }

}
