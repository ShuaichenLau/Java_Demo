package com.alice;

import java.text.SimpleDateFormat;

/**
 * 获取20位随机数
 * 4位年份+13位时间戳+3位随机数
 *
 * @author yuyu
 */
public class GetTimeUUID {
    public static void main(String[] args) {
        //调用生成id方法
        for (int i = 0; i < 1100; i++) {
            System.out.println(getGuid());
        }
    }

    /**
     * 20位末尾的数字id
     */
    public static volatile int Guid = 100;

    public static String getGuid() {

        GetTimeUUID.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        //获取时间戳
        String time = dateFormat.format(now);
        String info = now + "";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran = 0;
        if (GetTimeUUID.Guid > 999) {
            GetTimeUUID.Guid = 100;
        }
        ran = GetTimeUUID.Guid;

        return time + info.substring(2, info.length()) + ran;
    }
}