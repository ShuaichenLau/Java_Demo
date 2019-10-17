package com.alice.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class DateUtils {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar canlandar = Calendar.getInstance();
        canlandar.setTime(date);
        canlandar.add(canlandar.YEAR, 50);
        String syncTime = df.format(canlandar.getTime()).toString();
        System.out.println(syncTime);


        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));

        System.out.println(cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日");
        System.out.println(cal.get(Calendar.HOUR_OF_DAY) + "时" + cal.get(Calendar.MINUTE) + "分" + cal.get(Calendar.SECOND) + "秒");


        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));


        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        ConcurrentMap<Object, Object> objectObjectConcurrentMap = Maps.newConcurrentMap();
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = Maps.newLinkedHashMap();

        ArrayList<Object> objects = Lists.newArrayList();
        LinkedList<Object> objects1 = Lists.newLinkedList();


    }
}
