package org.example;

import com.spire.xls.*;

public class Copy2 {
    public static void main(String[] args) throws Exception{

        //加载文档1，并获取第一张工作表
        Workbook wb1 = new Workbook();
        wb1.loadFromFile("C:\\Users\\Administrator\\Desktop\\bbb\\新建 XLSX 工作表.xlsx");
        Worksheet sheet1 = wb1.getWorksheets().get("免责声明");

        //加载文档2，获取第三张工作表，并将文档1中的工作表内容复制到该工作表
        Workbook wb2 = new Workbook();
        wb2.loadFromFile("C:\\Users\\Administrator\\Desktop\\bbb\\abs_issue_statistics.xlsx");
        Worksheet sheet2 = wb2.getWorksheets().get("免责声明");

        sheet1.setName("1234");
        sheet1.copyFrom(sheet2);
        //保存文档
        wb1.saveToFile("C:\\Users\\Administrator\\Desktop\\bbb\\新建 XLSX 工作表.xlsx",FileFormat.Version2016);
    }
}