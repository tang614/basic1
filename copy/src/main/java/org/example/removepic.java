package org.example;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class removepic {
    public static void main(String[] args) throws Exception{
        String path = "C:\\Users\\Administrator\\Desktop\\0722modle\\abnormal_operation.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path));
        XSSFSheet sheet = workbook.getSheet("免责声明");
        //ImageUtils.removePicture(sheet);
        //ImageUtils.removeConnector(sheet);
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            sheet.removeMergedRegion(i);
        }

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                XSSFCell cell = row.getCell(j);
                cell.removeCellComment();

            }

        }
        workbook.write(new FileOutputStream(path));
    }
}
