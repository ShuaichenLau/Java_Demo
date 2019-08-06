package com.alice.main;

/*
 * 冒泡排序
 */
public class JavaBubbleSort {

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag;
        for (int i = arr.length - 1; i > 0; --i) { // 每次需要排序的长度
            flag = false;
            for (int j = 0; j < i; ++j) { // 从第一个元素到第i个元素
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }
}