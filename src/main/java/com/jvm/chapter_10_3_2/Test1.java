package com.jvm.chapter_10_3_2;

import java.util.Arrays;
import java.util.List;

/**
 * 测试语法糖
 * 泛型、自动装箱、自动拆箱、遍历循环、变长参数
 */
public class Test1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 如果在JDK1.7中，还有另外一颗语法糖，
        // 能让这句代码进一步简写程List<Integer> list = [1, 2, 3, 4];
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        System.out.println(sum);

    }

}
