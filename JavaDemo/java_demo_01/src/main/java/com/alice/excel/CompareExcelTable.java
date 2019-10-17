package com.alice.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class CompareExcelTable {

    public static void main(String[] args) throws Exception {

        List<String> compareExcelStrList = new ArrayList<>();
        compareExcelStrList = readExcel("D:\\GitHub_liusc\\Java_Demo\\java_demo_01\\src\\main\\resources\\要匹配的数据.xls");


        List<String> stringArrayList = new ArrayList<>();
        stringArrayList = readExcel("D:\\GitHub_liusc\\Java_Demo\\java_demo_01\\src\\main\\resources\\元数据.xls");




    }

    /**
     * 第一种方法
     * 读取excel单元格的内容并针对其type进行不同的处理,
     * 其中就包含  读取excel表格中日期格式的cell
     *
     * @param cell
     * @return
     */
    public static String readCellFirstMethod(HSSFCell cell) {
        if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
            }
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return cell.getStringCellValue();
        }
    }

    /**
     * 第二种方法
     * 读取excel单元格的内容并针对其type进行不同的处理,
     * 其中就包含  读取excel表格中日期格式的cell
     *
     * @param cell
     * @return
     */
    public static String readCellSecondMethod(HSSFCell cell) {
        //DecimalFormat df = new DecimalFormat("#");
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {

            //数字
            case HSSFCell.CELL_TYPE_NUMERIC:

                //日期格式的处理
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                }

                return String.valueOf(cell.getNumericCellValue());
            //return df.format(cell.getNumericCellValue());

            //字符串
            case HSSFCell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            //公式
            case HSSFCell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();

            //空白
            case HSSFCell.CELL_TYPE_BLANK:
                return "";

            //布尔取值
            case HSSFCell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() + "";

            //错误类型
            case HSSFCell.CELL_TYPE_ERROR:
                return cell.getErrorCellValue() + "";
        }

        return "";
    }


    public static List<String> readExcel(String path) throws Exception{

        List<String> list = new ArrayList<>();

        //读取一个excel表的内容
        InputStream stream = new FileInputStream(path);
        POIFSFileSystem fs = new POIFSFileSystem(stream);
        HSSFWorkbook wb = new HSSFWorkbook(fs);

        //获取excel表的第一个sheet
        HSSFSheet sheet = wb.getSheetAt(0);
        if (sheet == null) {
            return null;
        }

        //遍历该sheet的行
        for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
            HSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }

            //再遍历该行的所有列
            for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
                HSSFCell cell = row.getCell(cellNum);
                if (cell == null) {
                    continue;
                }


                String strVal = readCellSecondMethod(cell);
                if (cellNum == 2) {
                    strVal = strVal.contains(".") ? strVal.substring(0, strVal.indexOf(".")) : strVal;
                }

                System.out.print(" " + strVal);
                list.add(strVal);

                //System.out.print(" " + readCellFirstMethod(cell));
                //System.out.print(" " + readCellSecondMethod(cell));

            }
            System.out.println();
        }

        stream.close();
        return list;
    }


}