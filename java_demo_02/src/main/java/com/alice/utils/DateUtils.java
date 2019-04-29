package com.alice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar canlandar = Calendar.getInstance();
        canlandar.setTime(date);
        canlandar.add(canlandar.YEAR,50 );
        String syncTime=df.format(canlandar.getTime()).toString();
        System.out.println(syncTime);
    }
}
