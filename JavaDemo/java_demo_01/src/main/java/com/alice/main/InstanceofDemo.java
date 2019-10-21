package com.alice.main;

import com.alice.entity.Student;

import java.lang.reflect.Array;
import java.util.*;

public class InstanceofDemo {
    public static void main(String[] args) {
        Object students = new ArrayList<Student>();

        //使HashMap方法具有线程安全的能力
        Map<String, String> stringStringHashMap = new HashMap<String, String>();
        Collections.synchronizedMap(stringStringHashMap);

        if (students instanceof HashMap) {
            System.out.println("hashMap");
        } else if (students instanceof Array) {
            System.out.println("array");
        } else if (students instanceof ArrayList) {
            System.out.println("arraylist");
        }
    }
}
