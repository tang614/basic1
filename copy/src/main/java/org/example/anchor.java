package org.example;

import com.sun.org.apache.xml.internal.security.c14n.implementations.Canonicalizer20010315;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.xssf.usermodel.*;
import sun.awt.image.OffScreenImageSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class anchor {
    public static void main(String[] args) throws Exception{
        // 拿到模板文件 “免责声明” sheet的图片信息,将图片坐标向下移动一位
        String sourcePath = "C:\\Users\\Administrator\\Downloads\\EXCEL导出样例(含免责声明样式) (20210721).xlsx";
        XSSFWorkbook sourceWb = new XSSFWorkbook(new FileInputStream(sourcePath));
        XSSFSheet sourceWbSheet = sourceWb.getSheet("免责声明");
        List<Map<String, Object>> picturesDataList = POIUtils.getPicturesFromXSSFSheet(sourceWbSheet);
        for (int i = 0; i < picturesDataList.size(); i++) {
            XSSFClientAnchor pictureAnchor = (XSSFClientAnchor)picturesDataList.get(i).get("pictureAnchor");
            pictureAnchor.setRow1(pictureAnchor.getRow1()+1);
            pictureAnchor.setRow2(pictureAnchor.getRow2()+1);
        }

        // 要修改的文件所在文件夹
        String filePath = "C:\\Users\\Administrator\\Desktop\\1234";
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String path = files[i].getAbsolutePath();
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path));
            XSSFSheet sheet = workbook.getSheet("免责声明");

            // 删除sheet的图片
            ImageUtils.removePicture(sheet);

            //复制模板的图片到sheet
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            for (Map<String, Object> sourceSheetPicture : picturesDataList) {
                drawing.createPicture((XSSFClientAnchor) sourceSheetPicture.get("pictureAnchor"), workbook.addPicture((byte[]) sourceSheetPicture.get("pictureByteArray"),
                        Integer.parseInt(sourceSheetPicture.get("pictureType").toString())));
            }
            workbook.write(new FileOutputStream(path));
        }
    }
}
