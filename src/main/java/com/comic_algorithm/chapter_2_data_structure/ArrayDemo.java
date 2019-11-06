package com.comic_algorithm.chapter_2_data_structure;

/**
 * 《漫画算法》 2.1 数组
 * 在计算机科学中，数组数据结构（英语：array data structure），简称数组（英语：Array），
 * 是由相同类型的元素（element）的集合所组成的数据结构，分配一块连续的内存来存储。
 * 利用元素的索引（index）可以计算出该元素对应的存储地址。
 */
public class ArrayDemo {

    public static void main(String[] args) {

        int[] array = new int[] {3, 1, 2, 5, 4, 9, 7, 2};

        // 输出数组中下标为3的元素
        System.out.println(array[3]);
        // 给数组下标为5的元素赋值
        array[5] = 10;
        // 输出数组中下标为5的元素
        System.out.println(array[5]);
    }

}
