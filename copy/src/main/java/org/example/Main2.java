package org.example;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) throws Exception {
        String srcPath = "C:\\Users\\Administrator\\Desktop\\1\\a.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(srcPath));
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);

        XSSFCell cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());

        //row.createCell(6).setCellValue("");
        //row.createCell(7).setCellValue("");
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,8,10);

        sheet.addMergedRegionUnsafe(cellRangeAddress);

        workbook.write(new FileOutputStream(srcPath));

        /*String descPath = "C:\\Users\\Administrator\\Desktop\\1\\b.xlsx";
        XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(descPath));
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        XSSFRow row1 = sheet1.getRow(0);*/


    }
}
