package com.alice.exercise.main;

import com.alice.exercise.entity.Person;
import com.alice.exercise.entity.Student;

import java.util.Random;
import java.util.UUID;

public class HelloWorldVoidTest {

    public static void main(String[] args) {

        Student student = new Student();

//        updateStudent(student);
        new HelloWorldVoidTest().updateStudent1(student);

        System.out.println(student);


        int i = 10;

        sum(i);
        System.out.println(i);
    }

    private static void sum(int i) {
        i = i + 10;
    }

    private static void updateStudent(Student student) {

        if(student != null){
            student.setId(new Random().nextInt());
            student.setName(UUID.randomUUID().toString());
        }
    }

    private void updateStudent1(Student student) {

        if(student != null){
            student.setId(new Random().nextInt());
            student.setName(UUID.randomUUID().toString());
        }
    }




}
