package org.example;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class M4 {
    public static void main(String[] args) throws Exception{
        String srcPath = "C:\\Users\\Administrator\\Desktop\\bbb\\123.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(srcPath));
        XSSFSheet sheet = workbook.getSheetAt(0);
        /*boolean displayGridlines = sheet.isDisplayGridlines();*/
        /*if (displayGridlines)
            sheet.setDisplayGridlines(false);*/
        sheet.setDisplayGridlines(false);
        workbook.write(new FileOutputStream(srcPath));
    }
}
