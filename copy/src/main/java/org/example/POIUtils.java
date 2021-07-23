package org.example;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.xssf.usermodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author sunwei@finchina.com
 * @Date 2021/7/9 11:15
 * @Description
 **/
public class POIUtils {


    public static List<Map<String, Object>> getPicturesFromXSSFSheet(XSSFSheet sheet) {
        List<Map<String, Object>> result = new ArrayList<>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if (shape instanceof XSSFPicture) {
                        XSSFPicture picture = (XSSFPicture) shape;
                        XSSFClientAnchor anchor = picture.getPreferredSize();
                        Map<String, Object> map = new HashMap<>();
                        map.put("pictureAnchor", anchor);
                        map.put("pictureByteArray", picture.getPictureData().getData());
                        map.put("pictureType", picture.getPictureData().getPictureType());
                        result.add(map);
                    }
                }
            }
        }
        return result;
    }

    public static List<XSSFAnchor> getConnectorFromXSSFSheet(XSSFSheet sheet) {
        List<XSSFAnchor> result = new ArrayList<>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    if (shape instanceof XSSFConnector) {
                        XSSFConnector connector = (XSSFConnector) shape;
                        result.add(connector.getAnchor());
                    }
                }
            }
        }
        return result;
    }

    public static void copyPicture(XSSFSheet sourceSheet, XSSFSheet targetSheet, XSSFWorkbook descWorkbook) {
        XSSFDrawing drawing = targetSheet.createDrawingPatriarch();
        List<Map<String, Object>> result = getPicturesFromXSSFSheet(sourceSheet);
        for (Map<String, Object> sourceSheetPicture : result) {
            drawing.createPicture((XSSFClientAnchor) sourceSheetPicture.get("pictureAnchor"), descWorkbook.addPicture((byte[]) sourceSheetPicture.get("pictureByteArray"),
                    Integer.parseInt(sourceSheetPicture.get("pictureType").toString())));
        }

    }

    public static void copyConnector(XSSFSheet sourceSheet, XSSFSheet targetSheet, XSSFWorkbook descWorkbook) {
        XSSFDrawing drawing = targetSheet.createDrawingPatriarch();
        List<XSSFAnchor> result = getConnectorFromXSSFSheet(sourceSheet);
        for (XSSFAnchor xssfAnchor : result) {
            drawing.createConnector((XSSFClientAnchor) xssfAnchor);
        }
    }
}
