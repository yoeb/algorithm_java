package com.comic_algorithm.chapter_1;

/**
 * 《漫画算法》1.2 时间复杂度
 */
public class TimeComplexityDemo {

    public static void main(String[] args) {
        eat4(10);
    }

    /**
     * 给小灰1个长度为n cm的面包，小灰每3分钟吃掉1cm，那么吃掉整个面包需要多久
     * T(n) = 3n
     * 时间复杂度O(n)
     */
    static void eat1(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("吃1cm面包");
        }
    }

    /**
     * 给小灰1个长度为16cm的面包，小灰每5分钟吃掉面包剩余长度的一半，即第5分钟
     * 吃掉8cm，第10分钟吃掉4cm，第15分钟吃掉2cm...... 那么小灰把面包吃得只剩
     * 1cm，需要多久呢？
     * 时间复杂度O(log n)
     */
    static void eat2(int n) {
        for (int i = n; i>1 ; i /= 2) {
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("吃一半面包");
        }
    }

    /**
     * 给小灰1个长度为10cm的面包和1个鸡腿，小灰每2分钟吃掉1个鸡腿。那么小灰
     * 吃掉整个鸡腿需要多久呢？
     * T(n) = 2
     * 时间复杂度O(1)
     */
    static void eat3(int n) {
        System.out.println("等待1分钟");
        System.out.println("吃一个鸡腿");
    }

    /**
     * 给小灰1个长度为10cm的面包，小灰吃掉第1个1cm需要1min，吃掉第2个1cm需要2min，
     * 吃掉第三个1cm需要3min...... 每吃1cm所花的时间就比吃上一个1cm多用1min。那么
     * 小灰吃掉整个面包需要多久呢？
     * 时间复杂度O(n²)
     */
    static void eat4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("等待1分钟");
            }
            System.out.println("吃1cm 面包");
        }
    }

}
