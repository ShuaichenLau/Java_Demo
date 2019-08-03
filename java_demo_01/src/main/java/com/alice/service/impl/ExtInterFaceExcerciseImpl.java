package com.alice.service.impl;

import com.alice.service.ExtInterFaceExcercise;

public class ExtInterFaceExcerciseImpl implements ExtInterFaceExcercise {

    @Override
    public String addUser(String userName, String Address) {
        return null;
    }

    @Override
    public String deleteUser(String Id) {
        return "com.alice.service.impl.ExtInterFaceExcerciseImpl.deleteUser ==> " + Id;
    }
}
