package com.alice.service;

public interface StudentService {

    boolean InsertStudent();


    default String getUser(){
        return "alice";
    }

    static String getAlice(){
        return "alice";
    }
}
