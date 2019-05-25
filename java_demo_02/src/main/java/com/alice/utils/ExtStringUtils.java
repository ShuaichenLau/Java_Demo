package com.alice.utils;

public class ExtStringUtils {

    //首字母小写
    public static String toLowerCaseFirstOne(String str){
        if(Character.isLowerCase(str.charAt(0))){
            return str;
        }else {
            return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
        }
    }


    public static void main(String[] args) {
        System.out.println(ExtStringUtils.toLowerCaseFirstOne("HelloWorld"));
    }
}
