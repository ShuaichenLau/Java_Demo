package com.alice.exercise.main;

/**
 * @author liusc
 * 测试 if else
 */
public class Test03 {

    public static void main(String[] args) {

        String str = "0005";
        String companyNatureName1 = "";
        String companyNatureName2 = "";


        if (!"".equals(str)) {
            String companyNature = "100";
            if (null != companyNature && "57~60~79".indexOf(companyNature) > -1) {
                companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                companyNatureName2 = " ■个体、私营企业      □其他企业        □其他";
            } else if (null != companyNature && "15~16".indexOf(companyNature) > -1) {
                companyNatureName1 = " ■党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
            } else if (null != companyNature && "48".indexOf(companyNature) > -1) {
                companyNatureName1 = " □党政机关、团体      ■事业单位        □军队（武警）       □使（领）馆 ";
                companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
            } else if (null != companyNature && "56".indexOf(companyNature) > -1) {
                companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                companyNatureName2 = " □个体、私营企业      ■其他企业        □其他";
            } else if (null != companyNature && "61".indexOf(companyNature) > -1) {
                companyNatureName1 = " □党政机关、团体      □事业单位        ■军队（武警）       □使（领）馆 ";
                companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
            } else if (null != companyNature && "62".indexOf(companyNature) > -1) {
                companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       ■使（领）馆 ";
                companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
            } else if (!"".equals(str) && "".equals(companyNatureName1)) {
                if ("0001".equals(str)) {
                    companyNatureName1 = " ■党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
                } else if ("0002".equals(str)) {
                    companyNatureName1 = " □党政机关、团体      ■事业单位        □军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
                } else if ("0003".equals(str)) {
                    companyNatureName1 = " ■党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
                } else if ("0004".equals(str)) {
                    companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      ■其他企业        □其他";
                } else if ("0007".equals(str)) {
                    companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " ■个体、私营企业      □其他企业        □其他";
                } else if ("0008".equals(str)) {
                    companyNatureName1 = " □党政机关、团体      □事业单位        ■军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
                } else if ("0009".equals(str)) {
                    companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       ■使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
                } else {
                    companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                    companyNatureName2 = " □个体、私营企业      □其他企业        ■其他";
                }
            } else {
                companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
                companyNatureName2 = " □个体、私营企业      □其他企业        ■其他";
            }
        } else {
            companyNatureName1 = " □党政机关、团体      □事业单位        □军队（武警）       □使（领）馆 ";
            companyNatureName2 = " □个体、私营企业      □其他企业        □其他";
        }

        System.out.println(companyNatureName1);
        System.out.println(companyNatureName2);
    }
}
