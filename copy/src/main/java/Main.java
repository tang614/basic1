import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Administrator\\Desktop\\新excel模板\\news";
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String filePath = files[i].getAbsolutePath();

            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            xssfWorkbook.setActiveSheet(0);
            XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);


            /*XSSFSheet sheet = xssfWorkbook.getSheet("免责声明");

            XSSFCell cell = sheet.getRow(2).getCell(1);
            cell.setCellValue("免责声明");

            XSSFCell cell1 = sheet.getRow(12).getCell(1);
            cell1.setCellValue("了解企业预警通");

            XSSFCell cell2 = sheet.getRow(34).getCell(1);
            cell2.setCellValue("联系我们");

            XSSFCell cell3 = sheet.getRow(29).getCell(1);
            cell3.setCellValue("精准预警 专业极速");

            XSSFCell cell4 = sheet.getRow(21).getCell(5);
            cell4.setCellValue("企业预警通PC版");

            XSSFCell cell5 = sheet.getRow(21).getCell(9);
            cell5.setCellValue("城投宝小程序");

            XSSFCell cell6 = sheet.getRow(29).getCell(9);
            cell6.setCellValue("专业的地区经济与\n城投平台查询工具");*/


            xssfWorkbook.write(new FileOutputStream(filePath));
        }
    }
}
