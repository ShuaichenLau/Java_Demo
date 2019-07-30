package com.alice.excel;


import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;

/**
 * 写excel
 *
 * @author liusc
 */
public class ExcelWrite {

    public static void main(String[] args) throws Exception {

        List<String> sourceDataList = CompareExcelTable.readExcel("D:\\GitHub_liusc\\Java_Demo\\java_demo_01\\src\\main\\resources\\元数据.xls");
        List<String> matchingDataList = CompareExcelTable.readExcel("D:\\GitHub_liusc\\Java_Demo\\java_demo_01\\src\\main\\resources\\要匹配的数据.xls");

        //创建一个工作簿 即excel文件,再在该文件中创建一个sheet
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet01");

        for (int i = 0; i < matchingDataList.size(); i++) {
            for (int i1 = 0; i1 < sourceDataList.size(); i1++) {

                if(SimFeatureUtil.ld(matchingDataList.get(i),sourceDataList.get(i1)) > 0.8){
                    HSSFRow row = sheet.getRow(i);
                    if (row != null) {
                        int k = 1;
                        String stringCellValue = row.getCell(k).getStringCellValue();
                        if("".equals(stringCellValue)){
                            row.createCell(k).setCellValue(sourceDataList.get(i1));
                        }else {
                            row.createCell(++k).setCellValue(sourceDataList.get(i1));
                        }
                    }

                }
            }

        }


        //在sheet中创建一行
        HSSFRow row = sheet.createRow(0);

        //在该行写入各种类型的数据
        row.createCell(0).setCellValue(true);
        row.createCell(1).setCellValue("钟林森");
        row.createCell(2).setCellValue(23);

        //设置保留两位小数
        HSSFCell cell = row.createCell(3);
        cell.setCellValue(6000);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        cell.setCellStyle(cellStyle);

        //在写入 日期格式的 数据需要进行特殊处理(这是一种 简单的处理方式)
        CreationHelper createHelper = wb.getCreationHelper();
        HSSFCellStyle style = wb.createCellStyle();
        style.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));

        cell = row.createCell(4);
        cell.setCellValue(new Date());
        cell.setCellStyle(style);

        //最后写回磁盘
        FileOutputStream out = new FileOutputStream("D:\\GitHub_liusc\\Java_Demo\\java_demo_01\\src\\main\\resources\\要匹配的数据01.xls");
        wb.write(out);
        out.close();

        System.out.println("写完了!");
    }
}