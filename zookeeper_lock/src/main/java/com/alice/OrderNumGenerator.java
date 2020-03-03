package com.alice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNumGenerator {

    //全局订单ID
    private static int count = 0;


    public String getNumber(){

//
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        return dateFormat.format(new Date()) + "  --  " + ++count;

    }
}
