package com.alice.main;

/**
 * 题目 1-99 数字转中文
 */
public class Test007 {

    public static void main(String[] args) {

        System.out.println(getString(1));

        System.out.println(appendStr(11));
        System.out.println(appendStr(21));
        System.out.println(appendStr(10));
        System.out.println(appendStr(9));
        System.out.println(appendStr(99));

    }

    public static String appendStr(int num) {

        StringBuilder stringBuilder = new StringBuilder();

        if (num <= 19 && num > 9) {
            stringBuilder.append("十");
            if (num != 10) {
                stringBuilder.append(getString(num / 10));
            }
        } else if (num > 19 && num <= 99) {
            stringBuilder.append(getString(num / 10)).append("十").append(getString(num % 10));
        }else {
            stringBuilder.append(getString(num));
        }

        return stringBuilder.toString();
    }


    public static String getString(int num) {

        StringBuilder stringBuilder = new StringBuilder();

        switch (num) {
            case 1:
                stringBuilder.append("一");
                break;
            case 2:
                stringBuilder.append("二");
                break;
            case 3:
                stringBuilder.append("三");
                break;
            case 4:
                stringBuilder.append("四");
                break;
            case 5:
                stringBuilder.append("五");
                break;
            case 6:
                stringBuilder.append("六");
                break;
            case 7:
                stringBuilder.append("七");
                break;
            case 8:
                stringBuilder.append("八");
                break;
            case 9:
                stringBuilder.append("九");
                break;
        }
        return stringBuilder.toString();
    }
}
