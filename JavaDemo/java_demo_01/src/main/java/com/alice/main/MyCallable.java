package com.alice.main;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return i;
    }

    private String i;

    public MyCallable(String i) {
        this.i = i;
    }
}
