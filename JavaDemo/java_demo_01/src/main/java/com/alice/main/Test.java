package com.alice.main;

import com.alice.entity.Student;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        try {
            Class<?> aClass = Class.forName("com.alice.entity.Student");
            Object instance = aClass.newInstance();
            if(instance instanceof Student){
                System.out.println(instance.hashCode());
                ((Student) instance).setId(1);
                ((Student) instance).setName("alice");
                ((Student) instance).setAge(20);
                ((Student) instance).setAddress("北京市昌平区");
                System.out.println(instance.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }


    public static void testString() {
        String a = "a" + "b";
        String b = "a" + new String("b");
        System.out.println(a == b);

        int x = 1;
        Integer y = new Integer(1);
        System.out.println(x == y);
    }
}
