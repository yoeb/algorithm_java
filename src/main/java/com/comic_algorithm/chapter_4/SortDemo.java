package com.comic_algorithm.chapter_4;

import java.util.Arrays;

/**
 * 排序算法
 */
public class SortDemo {

    private static int[] arr = {3, 5, 2, 1, 6, 7, 8, 9};


    public static void main(String[] args) {
        System.out.println("===========排序前===========");
        System.out.println(Arrays.toString(arr));

        // bubbleSort(arr);
        quickSort(arr, 0, arr.length - 1);

        System.out.println("===========排序后===========");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     */
    static void bubbleSort(int[] arr) {

        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    /**
     * 快速排序 分治法
     * 平均时间复杂度O(n log n)
     */
    static void quickSort(int[] arr, int startIndex, int endIndex) {

        // 递归结束条件： startIndex >= endIndex时
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr,pivotIndex + 1, endIndex);

    }

    /**
     * 分治（双边循环法）
     * @param arr 待交换的数组
     * @param startIndex 起始下标
     * @param endIndex 结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第1个位置(也可以选择随机位置)的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right --;
            }
            // 控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left ++;
            }
            // 交换left和right指针所指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        // pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

}
