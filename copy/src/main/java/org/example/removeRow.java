package org.example;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 1、将"免责声明"sheet的大片文字修改
 * 2、将第9行行高变为0.1，已达到删除整行的作用
 */

public class removeRow {
    public static void main(String[] args) throws Exception{
        // 目标文件夹
        String path = "C:\\Users\\Administrator\\Desktop\\1234";
        File file = new File(path);
        File[] files = file.listFiles();
        for (int j = 0; j < files.length; j++) {
            String descPath = files[j].getAbsolutePath();
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(descPath));
            XSSFSheet sheet = workbook.getSheet("免责声明");

            for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
                CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
                if (mergedRegion.getFirstRow() == 4 && mergedRegion.getLastRow() == 4 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    //sheet.removeMergedRegion(i);
                    mergedRegion.setLastColumn(12);
                    //sheet.addMergedRegion(mergedRegion);
                    XSSFCell cell = sheet.getRow(4).getCell(1);
                    cell.setCellValue("本数据内容版权归企业预警通所有。任何人未获得书面授权，不得对本数据内容进行转载、发布；如需引用，应注明来源于");
                }
                if (mergedRegion.getFirstRow() == 5 && mergedRegion.getLastRow() == 5 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(5).getCell(1);
                    cell.setCellValue("“企业预警通”。特别提示，企业预警通的数据内容均基于公开信息或已取得授权的信息经编辑整理而成，本公司力求数据");
                }
                if (mergedRegion.getFirstRow() == 6 && mergedRegion.getLastRow() == 6 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(6).getCell(1);
                    cell.setCellValue("准确与完整，但不对其准确性及完整性作任何保证，且不构成任何投资建议或者其他实际操作的意见。在任何情况下，本公");
                }
                if (mergedRegion.getFirstRow() == 7 && mergedRegion.getLastRow() == 7 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(7).getCell(1);
                    cell.setCellValue("司不对任何人因使用本数据内容引致的任何损失承担任何责任。市场有风险，投资需谨慎。");
                }
                if (mergedRegion.getFirstRow() == 8 && mergedRegion.getLastRow() == 8 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(8).getCell(1);
                    cell.setCellValue("");
                }
                if (mergedRegion.getFirstRow() == 14 && mergedRegion.getLastRow() == 14 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(14).getCell(1);
                    cell.setCellValue("企业预警通是上海大智慧财汇数据科技有限公司倾力打造的企业风险智能监控工具，包括企业预警通APP、企业预警通专业");
                }
                if (mergedRegion.getFirstRow() == 15 && mergedRegion.getLastRow() == 15 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(15).getCell(1);
                    cell.setCellValue("版（PC）、城投宝小程序等系列产品。该产品通过融合海量的金融、企业、舆情、信用、司法、区域经济等大数据资源，");
                }
                if (mergedRegion.getFirstRow() == 16 && mergedRegion.getLastRow() == 16 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(16).getCell(1);
                    cell.setCellValue("运用人工智能、机器学习、自然语言处理技术，建立数据智能采集、分析及挖掘模型，实现企业多维度风险信息查询、监测");
                }
                if (mergedRegion.getFirstRow() == 17 && mergedRegion.getLastRow() == 17 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(17).getCell(1);
                    cell.setCellValue("与分析。广泛应用于合规、风控、信贷、投行、供应链金融、公共关系、监管等众多业务场景，目前已为近百万金融专业用");
                }
                if (mergedRegion.getFirstRow() == 18 && mergedRegion.getLastRow() == 18 && mergedRegion.getFirstColumn() == 1 && mergedRegion.getLastColumn() == 11) {
                    mergedRegion.setLastColumn(12);
                    XSSFCell cell = sheet.getRow(18).getCell(1);
                    cell.setCellValue("户提供数据服务，获得了广大用户的支持和认可。");
                }
                XSSFRow row = sheet.getRow(8);
                row.setHeight((short) 0.001);
                workbook.write(new FileOutputStream(descPath));
            }
        }
    }
}
