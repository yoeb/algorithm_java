package com.comic_algorithm.chapter_1;

/**
 * 《漫画算法》 1.3 空间复杂度
 */
public class SpaceComplexityDemo {

    public static void main(String[] args) {

    }

    /**
     * 1.常量空间
     * 当算法的存储空间大小固定，和输入规模没有直接的关系时，空间复杂度
     * 记作O(1)
     */
    static void fun1(int n) {
        int var = 3;
    }

    /**
     * 2.线性空间
     * 当算法分配的空间是一个线性的集合(如数组)，并且集合大小和输出规模n
     * 成正比时，空间复杂度记作O(n)。
     */
    static void fun2(int n) {
        int[] array = new int[n];
    }

    /**
     * 3.二维空间
     * 当算法分配的空间是一个二维数组集合，并且集合的长度和宽度都与输入规模n
     * 成正比时，空间复杂度记作O(n²)。
     */
    static void fun3(int n) {
        int[][] matrix = new int[n][n];
    }

    /**
     * 4.递归空间
     * 空间复杂度O(n)
     */
    static void fun4(int n) {
        if (n <= 1) {
            return;
        }
        fun4(n - 1);
    }

}
