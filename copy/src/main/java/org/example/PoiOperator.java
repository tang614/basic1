package org.example;

import cn.hutool.core.io.IoUtil;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * @Author sunwei@finchina.com
 * @Date 2021/7/9 9:49
 * @Description
 **/
public class PoiOperator {

    private static final Logger logger = LoggerFactory.getLogger(PoiOperator.class);

    public void replace(String sourcePath, String descPath) {
        //获取需要替换的excel模板
        XSSFWorkbook xssfWorkbook = getWorkbook(sourcePath);
        if (Objects.isNull(xssfWorkbook)) {
            return;
        }
        File rootDirectory = new File(descPath);
        if (rootDirectory.isDirectory() && Objects.nonNull(rootDirectory.listFiles())) {
            //循环处理文件
            for (File file : rootDirectory.listFiles()) {
                replace(xssfWorkbook, file);
            }
        }
    }

    private XSSFWorkbook getWorkbook(String path) {
        XSSFWorkbook workbook = null;
        try {
            File file = new File(path);
            workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        } catch (Exception e) {
            logger.error("异常", e);
        }
        return workbook;
    }

    private void replace(XSSFWorkbook srcWb, File file) {
        try {
            //----------------------------
            //获取workbook
            XSSFWorkbook descWb = (XSSFWorkbook) WorkbookFactory.create(file);
            //删除原来的"免责申明"
            int index = descWb.getSheetIndex("免责声明");
            descWb.removeSheetAt(index);
            //设置样式--内容
            XSSFCellStyle cellStyle = descWb.createCellStyle();
            XSSFFont font = descWb.createFont();//设置字体
            font.setFontName("微软雅黑");//字体样式
            font.setFontHeightInPoints((short) 12);//字体大小
            cellStyle.setFont(font);

            // 修改字体内容和样式
            /*Iterator<Sheet> sheetIterator = descWb.sheetIterator();
            while (sheetIterator.hasNext()){
                Sheet next = sheetIterator.next();
                //next.createFreezePane(0, 2, 0, 2);

                Cell cell = next.getRow(0).getCell(0);
                cell.setCellValue("数据来源：企业预警通");
                //cell.setCellStyle(cellStyle);
            }*/
            //------------------------------------

            //替换
            XSSFSheet srcSheet = srcWb.getSheet("免责声明");
//            XSSFSheet destSheet = descWb.getSheet("免责声明");

            XSSFSheet destSheet2 = descWb.createSheet("免责声明");

            //destSheet2.setDisplayGridlines(false);//设置不显示网格线

            // copy Sheet
            copySheets(destSheet2, srcSheet, true);
            // copy 图片
            POIUtils.copyPicture(srcSheet, destSheet2, descWb);
            //copy 分界线
            POIUtils.copyConnector(srcSheet, destSheet2, descWb);
            //destSheet2.setDisplayGridlines(true);
            destSheet2.setDisplayGridlines(false);//设置不显示网格线
            //destSheet2.setPrintGridlines();

            // 遍历前n个sheet，
            int number = descWb.getNumberOfSheets();
            for (int i1 = 0; i1 < number - 1; i1++) {
                XSSFSheet next = descWb.getSheetAt(i1);
                // 字体格式
                XSSFCellStyle cellStyle1 = descWb.createCellStyle();
                XSSFFont font1 = descWb.createFont();//设置字体
                font1.setFontName("华文细黑");//字体样式
                font1.setFontHeightInPoints((short) 10);//字体大小
                cellStyle1.setFont(font1);
                cellStyle1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

                // 修改cell(0,0)
                Cell cell = next.getRow(0).getCell(0);
                cell.setCellValue("数据来源：企业预警通");
                cell.setCellStyle(cellStyle1);
                // 超链接到本文档的免责sheet
                XSSFCreationHelper creationHelper = descWb.getCreationHelper();
                XSSFHyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
                hyperlink.setAddress("#免责声明!A1");
                cell.setHyperlink(hyperlink);

                XSSFCreationHelper creationHelper1 = descWb.getCreationHelper();
                XSSFHyperlink hyperlink1 = creationHelper1.createHyperlink(HyperlinkType.DOCUMENT);
                hyperlink1.setAddress("#免责声明!A1");
                XSSFCell cell1 = next.getRow(0).getCell(1);
                cell1.setHyperlink(hyperlink1);
            }

            //写入文件
            writeToFile(descWb, file.getAbsolutePath());
        } catch (Exception e) {
            logger.error("异常", e);
        }
    }


    public static void copySheets(XSSFSheet destSheet, XSSFSheet srcSheet, boolean copyStyle) {
        int maxColumnNum = 0;
        Map<Integer, XSSFCellStyle> styleMap = (copyStyle) ? new HashMap<>() : null;
        for (int i = srcSheet.getFirstRowNum(); i <= srcSheet.getLastRowNum(); i++) {
            XSSFRow srcRow = srcSheet.getRow(i);
            XSSFRow destRow = destSheet.createRow(i);
            if (srcRow != null) {
                copyRow(srcSheet, destSheet, srcRow, destRow, styleMap);
                if (srcRow.getLastCellNum() > maxColumnNum) {
                    maxColumnNum = srcRow.getLastCellNum();
                }
            }
        }




        for (int j = 0; j <= maxColumnNum; j++) {    //设置列宽
            destSheet.setColumnWidth(j, srcSheet.getColumnWidth(j));
        }

        // copy合并单元格
        /*List<CellRangeAddress> list = srcSheet.getMergedRegions();
        for (int i = 0; i < srcSheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRangeAddress = list.get(i);
            CellRangeAddress cellRangeAddress1 = new CellRangeAddress(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(),
                    cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn());
            destSheet.addMergedRegion(cellRangeAddress1);
        }*/
    }

    /**
     * 复制并合并单元格
     */
    public static void copyRow(XSSFSheet srcSheet, XSSFSheet destSheet, XSSFRow srcRow, XSSFRow destRow, Map<Integer, XSSFCellStyle> styleMap) {
        Set<CellRangeAddressWrapper> mergedRegions = new TreeSet<>();
        destRow.setHeight(srcRow.getHeight());
        int deltaRows = destRow.getRowNum() - srcRow.getRowNum(); //如果copy到另一个sheet的起始行数不同
        for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
            XSSFCell oldCell = srcRow.getCell(j); // old cell
            XSSFCell newCell = destRow.getCell(j); // new cell
            if (oldCell != null) {
                if (newCell == null) {
                    newCell = destRow.createCell(j);
                }
                copyCell(oldCell, newCell, styleMap);
                CellRangeAddress mergedRegion = getMergedRegion(srcSheet, srcRow.getRowNum(), (short) oldCell.getColumnIndex());
                if (mergedRegion != null) {
                    CellRangeAddress newMergedRegion = new CellRangeAddress(
                            mergedRegion.getFirstRow() + deltaRows,
                            mergedRegion.getLastRow() + deltaRows,
                            mergedRegion.getFirstColumn(), mergedRegion.getLastColumn());
                    CellRangeAddressWrapper wrapper = new CellRangeAddressWrapper(newMergedRegion);
                    if (isNewMergedRegion(wrapper, mergedRegions)) {
                        mergedRegions.add(wrapper);
                        try {
                            destSheet.addMergedRegionUnsafe(wrapper.getRange());
                        } catch (Exception e) {
                            logger.error("异常", e);
                        }
                    }
                }


                }
            }


    }


    /**
     * 把原来的Sheet中cell（列）的样式和数据类型复制到新的sheet的cell（列）中
     *
     * @param oldCell
     * @param newCell
     * @param styleMap
     */
    public static void copyCell(XSSFCell oldCell, XSSFCell newCell,
                                Map<Integer, XSSFCellStyle> styleMap) {
        if (styleMap != null) {
            if (oldCell.getSheet().getWorkbook() == newCell.getSheet()
                    .getWorkbook()) {
                newCell.setCellStyle(oldCell.getCellStyle());
            } else {
                int stHashCode = oldCell.getCellStyle().hashCode();
                XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
                if (newCellStyle == null) {
                    newCellStyle = newCell.getSheet().getWorkbook()
                            .createCellStyle();
                    newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
                    styleMap.put(stHashCode, newCellStyle);
                }
                newCell.setCellStyle(newCellStyle);
            }
        }
        switch (oldCell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                newCell.setCellValue(oldCell.getStringCellValue());
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                newCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                newCell.setCellErrorValue(oldCell.getErrorCellValue());
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            default:
                break;
        }

    }

    // 获取merge对象
    public static CellRangeAddress getMergedRegion(XSSFSheet sheet, int rowNum, short cellNum) {
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress merged = sheet.getMergedRegion(i);
            if (merged.isInRange(rowNum, cellNum)) {
                return merged;
            }
        }
        return null;
    }

    private static boolean isNewMergedRegion(
            CellRangeAddressWrapper newMergedRegion,
            Set<CellRangeAddressWrapper> mergedRegions) {
        boolean bool = mergedRegions.contains(newMergedRegion);
        return !bool;
    }


    /**
     * @date 2021/7/9 10:21
     * @description 写入文件
     */
    private void writeToFile(XSSFWorkbook workbook, String fileName) throws IOException {
        //写出输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        byte[] bookByteAry = out.toByteArray();
        InputStream in = new ByteArrayInputStream(bookByteAry);
        //文件输入流
        File f = new File(fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(f);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            IoUtil.copy(in, bufferedOutputStream);
        } catch (IOException e) {
            logger.error("写入到文件失败", e);
        }
    }
}

