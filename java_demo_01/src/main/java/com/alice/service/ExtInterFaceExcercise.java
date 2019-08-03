package com.alice.service;

@FunctionalInterface
public interface ExtInterFaceExcercise {

    String addUser(String userName, String Address);

    default String deleteUser(int Id){
        return "com.alice.service.Hose.deleteUser";
    }

    static String updateUser(int Id){
        return "com.alice.service.Hose.updateUser";
    }

}
