package org.example;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Objects;

/*import static org.example.poi.PoiOperator.getWorkbook;
import static org.example.poi.PoiOperator.writeToFile;*/

/**
 * @Author sunwei@finchina.com
 * @Date 2021/7/22 9:21
 * @Description
 **/
public class ImageUtils {
    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    /*public static void main(String[] args) {
        replaceImage("C:\\Users\\Administrator\\Desktop\\excel\\EXCEL导出样例(含免责声明样式) (20210721).xlsx", "C:\\Users\\Administrator\\Desktop\\excel\\test");
    }*/

    //删除图片
    /*public static void replaceImage(String excelPath, String rootPath) {
        //获取需要替换的excel模板
        XSSFWorkbook xssfWorkbook = getWorkbook(excelPath);
        if (Objects.isNull(xssfWorkbook)) {
            return;
        }
        File rootDirectory = new File(rootPath);
        if (rootDirectory.isDirectory() && Objects.nonNull(rootDirectory.listFiles())) {
            //循环处理文件
            for (File file : rootDirectory.listFiles()) {
                try {
                    //获取workbook
                    XSSFWorkbook descWb = (XSSFWorkbook) WorkbookFactory.create(file);
                    //源sheet
                    XSSFSheet srcSheet = xssfWorkbook.getSheet("免责声明");
                    //目标sheet
                    XSSFSheet destSheet = descWb.getSheet("免责声明");
                    //删除图片
                    ImageUtils.removeImages(destSheet);
                    // copy 图片
                    POIUtils.copyPicture(srcSheet, destSheet, descWb);
                    //写入文件
                    writeToFile(descWb, file.getAbsolutePath() + "_copyed.xlsx");
                } catch (Exception e) {
                    logger.error("异常", e);
                }
            }
        }
    }*/


    public static void removeConnector(XSSFSheet sheet) {
        for (POIXMLDocumentPart dr : sheet.getRelations()) {
            if (dr instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) dr;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if (shape instanceof XSSFConnector) {
                        XSSFConnector connector = (XSSFConnector) shape;
                        try {
                            XSSFClientAnchor anchor = (XSSFClientAnchor)connector.getAnchor();
                            anchor.setDx1(0);
                            anchor.setDy1(0);
                            anchor.setCol1(0);
                            anchor.setRow1(0);
                            anchor.setDx2(0);
                            anchor.setDy2(0);
                            anchor.setRow2(0);
                            anchor.setCol2(0);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    public static void removePicture(XSSFSheet sheet) {
        for (POIXMLDocumentPart dr : sheet.getRelations()) {
            if (dr instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) dr;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if (shape instanceof XSSFPicture) {
                        XSSFPicture picture = (XSSFPicture) shape;
                        try {
                            XSSFClientAnchor anchor2 = picture.getPreferredSize();
                            XSSFAnchor anchor = picture.getAnchor();
                            anchor2.setCol1(0);
                            anchor2.setCol2(0);
                            anchor2.setDx1(0);
                            anchor2.setDx2(0);
                            anchor2.setDy1(0);
                            anchor2.setDy2(0);
                            anchor2.setRow1(0);
                            anchor2.setRow2(0);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }
}
