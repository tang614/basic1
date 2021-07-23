package org.example;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 设置前n-1个sheet的(0,0)超链接
 * 设置http 蓝色以及超链接
 */
public class qw {
    public static void main(String[] args) throws Exception{
        //目标文件夹
        String path = "C:\\Users\\Administrator\\Desktop\\1234";
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String descPath = files[i].getAbsolutePath();
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(descPath));

            // ------------修改前面n-1个sheet----------------------
            int number = workbook.getNumberOfSheets();
            for (int i1 = 0; i1 < number - 1; i1++) {
                XSSFSheet next = workbook.getSheetAt(i1);
                // 去除首行的合并单元格
                next.removeMergedRegion(0);
                // 字体格式
                XSSFCellStyle cellStyle = workbook.createCellStyle();
                XSSFFont font = workbook.createFont();//设置字体
                font.setFontName("华文细黑");//字体样式
                font.setFontHeightInPoints((short) 10);//字体大小
                cellStyle.setFont(font);
                cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

                // 修改cell(0,0)的格式
                Cell cell = next.getRow(0).getCell(0);
                cell.setCellStyle(cellStyle);

                // cell(0,0)超链接到本文档的免责sheet
                XSSFCreationHelper creationHelper = workbook.getCreationHelper();
                XSSFHyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
                hyperlink.setAddress("#免责声明!A1");
                cell.setHyperlink(hyperlink);

                // cell(0,1)超链接到本文档的免责sheet
                XSSFCreationHelper creationHelper1 = workbook.getCreationHelper();
                XSSFHyperlink hyperlink1 = creationHelper1.createHyperlink(HyperlinkType.DOCUMENT);
                hyperlink1.setAddress("#免责声明!A1");
                XSSFCell cell1 = next.getRow(0).getCell(1);
                cell1.setHyperlink(hyperlink1);

                // 前n-1个sheet默认选中(0,0)
                CellAddress address = next.getRow(0).getCell(0).getAddress();
                next.setActiveCell(address);
            }

            //------------------ 修改 免责声明sheet -------------
            // 修改url并设置超链接

            // 添加url超链接
            XSSFCreationHelper creationHelper2 = workbook.getCreationHelper();
            XSSFHyperlink hyperlink2 = creationHelper2.createHyperlink(HyperlinkType.URL);
            hyperlink2.setAddress("https://www.qyyjt.cn/");

            // 填充url
            XSSFSheet sheet = workbook.getSheet("免责声明");
            XSSFCell httpcell = sheet.getRow(29).getCell(5);
            httpcell.setHyperlink(hyperlink2);
            httpcell.setCellValue("https://www.qyyjt.cn/");

            // 设置字体
            XSSFCellStyle cellStyle1 = httpcell.getCellStyle();
            XSSFFont font = workbook.createFont();//设置字体
            font.setFontName("华文细黑");//字体样式
            font.setFontHeightInPoints((short) 10);//字体大小
            font.setColor(IndexedColors.BLUE.index);
            font.setUnderline(Font.U_SINGLE);//下划线
            cellStyle1.setFont(font);

            // "免责声明"sheet默认选中(0,0)
            CellAddress address1 = sheet.getRow(0).getCell(0).getAddress();
            sheet.setActiveCell(address1);

            List<POIXMLDocumentPart> list = sheet.getRelations();
            for (POIXMLDocumentPart part : list) {
                if (part instanceof XSSFDrawing) {
                    XSSFDrawing drawing = (XSSFDrawing) part;
                    List<XSSFShape> shapes = drawing.getShapes();
                    for (XSSFShape shape : shapes) {
                        if (shape instanceof XSSFConnector) {
                            XSSFConnector connector = (XSSFConnector) shape;
                            //connector.setNoFill(true);
                            //System.out.println(connector.getShapeType());
                            connector.setShapeType(2);
                        }
                    }
                }
            }

            workbook.write(new FileOutputStream(descPath));
        }
    }
}
