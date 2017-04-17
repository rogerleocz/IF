package com.atf.pageElement;

import com.atf.Interface.ConstantKeys;
import com.atf.pageElement.ExcelDate;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.openqa.selenium.Keys;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ice on 2017/2/16.
 */
public class ConnectExcel {

    public static String htmlPath = new LoadProperties().getConfigByKey(ConstantKeys.HtmlKeys);
    public static String keys = new LoadProperties().getConfigByKey(ConstantKeys.TitleKeys);
    public static List<List<ExcelDate>> lists = new ArrayList<List<ExcelDate>>();

    /**
     * 读取配置文件下所有测试数据到list并返回(并保存到 lists一份)
     * @return  excel 中所有测试数据的集合List<Data>
     */
    public static List<ExcelDate> getExcelData() {

        String dataPath = null;
        InputStream is = null;
        dataPath = new LoadProperties().getConfigByKey(ConstantKeys.TestDataKey);
        List<ExcelDate> list = new ArrayList<ExcelDate>();
        HSSFWorkbook hssfWorkbook = null;
        try {
            is = new FileInputStream(dataPath);
            hssfWorkbook = new HSSFWorkbook(is);
            int numSheet;
            for (numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // Read the Row
                List<ExcelDate> dataList = new ArrayList<ExcelDate>();
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        ExcelDate data = new ExcelDate();
                        HSSFCell id = hssfRow.getCell(0);
                        HSSFCell page = hssfRow.getCell(1);
                        HSSFCell operate = hssfRow.getCell(2);
                        HSSFCell operateType = hssfRow.getCell(3);
                        HSSFCell propertyValue = hssfRow.getCell(4);
                        HSSFCell testData = hssfRow.getCell(5);
                        HSSFCell remark = hssfRow.getCell(6);
                        data.setId(getValue(id));
                        data.setPage(getValue(page));
                        data.setOperate(getValue(operate));
                        data.setOperateType(getValue(operateType));
                        data.setPropertyValue(getValue(propertyValue));
                        data.setTestData(getValue(testData));
                        data.setRemark(getValue(remark));
                        data.setSheetNumber(numSheet);
                        list.add(data);
                        dataList.add(data);
                    }
                }
                lists.add(dataList);
                ExcelDate data = new ExcelDate();
                data.setFlag(true);
                data.setSheetNumber(numSheet);
                list.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                hssfWorkbook.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf((int) hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    public static void writeResultToList(Boolean flag) {
        if (NoneKeys.resultList == null) {
            NoneKeys.resultList = new ArrayList<Boolean>();
        }
        NoneKeys.resultList.add(flag);
    }

    /**
     * 将测试结果写入到excel
     *
     * @param sheetNumber
     * @param list        测试结果
     */
    public static void writeResult(int sheetNumber, List<Boolean> list) {

        String dataPath = new LoadProperties().getConfigByKey(ConstantKeys.TestDataKey);
        InputStream in = null;
        HSSFWorkbook hssfWorkbook = null;
        HSSFSheet hssfSheet = null;
        FileOutputStream fileOutputStream = null;
        try {
            in = new FileInputStream(dataPath);
            hssfWorkbook = new HSSFWorkbook(in);
            for (int i = 0; i < list.size(); i++) {
                boolean flag = list.get(i);
                hssfSheet = hssfWorkbook.getSheetAt(sheetNumber);
                HSSFRow hssfRow = hssfSheet.getRow(i + 1);
                Cell cell = hssfRow.createCell(7);
                HSSFCellStyle style = hssfWorkbook.createCellStyle();
                style.setAlignment(HorizontalAlignment.CENTER);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                if (flag == true) {
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    style.setFillForegroundColor(HSSFColor.GREEN.index);
                } else {
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    style.setFillForegroundColor(HSSFColor.RED.index);
                }
                cell.setCellValue(flag);
                cell.setCellStyle(style);
            }
            fileOutputStream = new FileOutputStream(dataPath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                hssfWorkbook.write(fileOutputStream);
                in.close();
                hssfWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将测试结果写到html文件,已case 为分隔,一个case 生成一个html
     * @param sheetNumber
     * @param result
     */
    public static void writeResultToHtml(int sheetNumber, List<Boolean> result) {

        StringBuilder stringBuilder = new StringBuilder();
        PrintStream printStream = null;
        String space = "&nbsp";
        String[] str = keys.split(",");
        String htmlName = htmlPath + "自动化测试报告-" + sheetNumber + ".html";
        try {
            printStream = new PrintStream(new FileOutputStream(htmlName, true));
            stringBuilder.append("<html>");
            stringBuilder.append("<head>");
            stringBuilder.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">");
            stringBuilder.append("<title>自动化测试报告</title>");
            stringBuilder.append("</head>");
            stringBuilder.append("<body>");
            stringBuilder.append("<div align=\"center\">");
            stringBuilder.append("<h1 style=\"text-align:center\">自动化测试报告</h1>");
            stringBuilder.append("<table border=\"1\" align=\"center\" cellspacing=\"0\" style=\"border-collapse:collapse;\">");
            stringBuilder.append("<tr>");
            for (int i = 0; i < str.length; i++) {
                stringBuilder.append("<th>" + str[i] + "</th>");
            }
            stringBuilder.append("</tr>");
            for (int j = 0; j < lists.get(sheetNumber).size(); j++) {
                ExcelDate data = lists.get(sheetNumber).get(j);
                stringBuilder.append("<tr>");
                stringBuilder.append("<td align=\"center\">" + space + data.getId() + space + "</td>");
                stringBuilder.append("<td align=\"center\">" + space + data.getPage() + space + "</td>");
                stringBuilder.append("<td align=\"center\">" + space + data.getOperate() + space + "</td>");
                stringBuilder.append("<td align=\"center\">" + space + data.getOperateType() + space + "</td>");
                stringBuilder.append("<td align=\"center\">" + space + data.getPropertyValue() + space + "</td>");
                stringBuilder.append("<td align=\"center\">" + space + data.getTestData() + space + "</td>");
                stringBuilder.append("<td align=\"center\">" + space + data.getRemark() + space + "</td>");
                String flag = result.get(j).toString();
                if (flag.equalsIgnoreCase("true")) {
                    stringBuilder.append("<td align=\"center\"><font size=\"4\" color=\"green\">" + "<strong>" + space + "成功" + space + "</strong></font></td>");
                } else {
                    stringBuilder.append("<td align=\"center\"><font size=\"4\" color=\"red\">" + "<strong>" + space + "失败" + space + "</strong></font></td>");
                }
                stringBuilder.append("<tr/>");
            }
            stringBuilder.append("</div></body></html>");
            printStream.append(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printStream.close();
        }
    }

}
