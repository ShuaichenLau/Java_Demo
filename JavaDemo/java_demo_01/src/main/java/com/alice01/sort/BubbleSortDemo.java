package com.alice01.sort;

import java.util.concurrent.Callable;

/**
 * @author liusc
 * 冒泡排序
 */
public class BubbleSortDemo {

    public static void bubbleSortDemo01(int[] a, int length) {

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (a[j] < a[j - 1]) {
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                }
            }
        }
    }

    public static void bubbleSortDemo02(int[] a, int n) {
        int j, k = n;
        boolean flag = true;//发生了交换就为true, 没发生就为false，第一次判断时必须标志位true。
        while (flag) {
            flag = false;//每次开始排序前，都设置flag为未排序过
            for (j = 1; j < k; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;

                    //表示交换过数据;
                    flag = true;
                }
            }
            k--;//减小一次排序的尾边界
        }//end while
    }//end


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 0, 9, 3, 12, 7, 8, 3, 4, 65, 22};

        BubbleSortDemo.bubbleSortDemo01(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();

    }
}
