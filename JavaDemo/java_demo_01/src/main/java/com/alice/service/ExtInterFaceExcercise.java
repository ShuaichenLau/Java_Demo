package com.alice.service;

@FunctionalInterface
public interface ExtInterFaceExcercise {

    String addUser(String userName, String Address);

    default String deleteUser(String Id) {
        return "com.alice.service.ExtInterFaceExcercise.deleteUser ==> " + Id;
    }

    static String updateUser(String Id) {
        return "com.alice.service.ExtInterFaceExcercise.updateUser ==> " + Id;
    }

}
