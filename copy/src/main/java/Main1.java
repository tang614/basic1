import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.POIUtils;
import org.example.PoiOperator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) throws Exception {
        String sourcePath = "C:\\Users\\Administrator\\Desktop\\新excel模板\\news\\abnormal_operation.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(sourcePath));
        XSSFSheet sheet = workbook.getSheet("免责声明");

        String descPath = "C:\\Users\\Administrator\\Desktop\\123.xlsx";
        XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(descPath));
        XSSFSheet sheet1 = workbook1.createSheet("免责声明");

        POIUtils.copyPicture(sheet,sheet1,workbook1);

        workbook1.write(new FileOutputStream(descPath));

        /*String sourcePath = "C:\\Users\\Administrator\\Desktop\\新excel模板\\news\\abnormal_operation.xlsx";
        String descPath = "C:\\Users\\Administrator\\Desktop\\1";
        PoiOperator poiOperator = new PoiOperator();
        poiOperator.replace(sourcePath,descPath);*/
    }
}
