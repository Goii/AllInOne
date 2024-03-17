package com.levi.interview_me.excel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: Levi
 * @createTime: 2024年03月17日 20:45:34
 * @version: 1.0
 * @Description: 导出带求和公式
 */
public class SumFormula {
    private static final Logger logger = LoggerFactory.getLogger(SumFormula.class);

    public static void main(String[] args) {
        // 创建新的工作簿
        Workbook workbook = new XSSFWorkbook();

        // 创建新的工作表
        Sheet sheet = workbook.createSheet("公式求和");
        createCellPlus(sheet);

        // 保存Excel文件
        try {
            FileOutputStream outputStream = new FileOutputStream("D://output.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("-----导出Excel程序报错-----");
        }
        logger.info("-----导出Excel程序运行完-----!");
    }

    /**
     * 基础公式 demo
     *
     * @param sheet
     */
    private static void createCell(Sheet sheet) {
        // 在工作表中添加数据和公式
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue(10);

        Row row2 = sheet.createRow(1);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue(20);

        //简单公式运算可以不用函数
        Cell cell3 = row2.createCell(1);
        cell3.setCellFormula("A1+A2");

        //函数运算直接写函数  不用带=   （=SUM()）
        Row row3 = sheet.createRow(2);
        Cell cell4 = row3.createCell(0);
        cell4.setCellFormula("SUM(A1:A2)");
    }


    /**
     * 跨行公式、复杂公式
     *
     * @param sheet
     */
    private static void createCellPlus(Sheet sheet) {
        sheet.createRow(0).createCell(0).setCellValue("数值、求和");
        for (int i = 1; i < 11; i++) {
            Row row = sheet.createRow(i);
            final Cell cell = row.createCell(0);
            cell.setCellValue(i * 2);
            if (i % 2 == 0) {
                final int num = i + 1;
                row.createCell(1).setCellFormula("SUM(A" + i + ",A" + num + ")");
            }
        }

    }
}
