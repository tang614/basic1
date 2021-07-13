import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main2 {
    public static void main(String[] args) throws Exception {
        String MyPath = "E:\\123.xlsx";
        FileInputStream fis = new FileInputStream(MyPath);

        //1.创建一个工作簿
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet1 = workbook.getSheet("价格偏离估值");
        //通过行下标和列下标返回cell对象
        Cell cell = sheet1.getRow(0).getCell(0);
        cell.setCellValue("呵呵呵呵呵呵呵");

        FileOutputStream fileOutputStream = new FileOutputStream(MyPath);
        workbook.write(fileOutputStream);
    }
}
