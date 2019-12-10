package com.alice.exercise.main;

import com.alice.exercise.entity.ThreadEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 内存泄露
 * 2019-11-26 20:13:44
 * <p>
 * 创建一个长时间运行的线程（使用线程池泄露的速度更快）。
 * <p>
 * 线程通过ClassLoader加载某个类（也可以用自定义ClassLoader）。
 * <p>
 * 这个类分配了大量内存（例如new byte[1000000]），赋给静态字段存储对它的强引用，然后在ThreadLocal中存储对自身的引用。还可以分配额外的内存，这样泄漏的速度更快（其实只要泄漏Class实例就足够了）。
 * <p>
 * 这个线程会清除所有自定义类及加载它的ClassLoader的引用。
 * <p>
 * 重复执行。
 */
public class Test02 {

    public static List<Object> list = new ArrayList<Object>();

    public static void main(String[] args) {

//        new BeanError();

//        for (int i = 0; i < 100000; i++) {
//            new Thread(new ThreadEntity()).start();
//        }




    }


    /**
     * java.lang.StackOverflowError
     * 死递归
     */
    public static void add() {

        ArrayList<Object> objects = new ArrayList<>();
        list.add(objects);
        add();
    }

}
