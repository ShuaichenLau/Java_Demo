package com.alice.main;

import com.alice.service.ExtInterFaceExcercise;
import com.alice.service.impl.ExtInterFaceExcerciseImpl;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test001 {

    public static void main(String[] args) {
        ExtInterFaceExcercise extInterFaceExcercise = (userName, Address) -> "userName:" + userName + " Address:" + Address;

        System.out.println(extInterFaceExcercise.addUser("alice", "BeiJing"));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        List<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
        stringArrayList.add("4");
        stringArrayList.add("5");

        stringArrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("str => " + s);
            }
        });

        List<Integer> integers = new ArrayList<Integer>();
        integers.add(01);
        integers.add(02);
        integers.add(03);
        integers.add(04);
        integers.add(05);
        integers.add(06);
        integers.forEach((o) -> System.out.println("integer => " + o));


        System.out.println(ExtInterFaceExcercise.updateUser("001"));

        System.out.println(new ExtInterFaceExcerciseImpl().deleteUser("002"));



    }
}
