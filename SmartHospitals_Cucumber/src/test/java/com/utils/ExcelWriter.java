package com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {
    public static void writeTableData(String filePath, String sheetName, List<List<String>> data, boolean append) {
        Workbook workbook;
        Sheet sheet;

        try {
            File file = new File(filePath);
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fis);
                    sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        sheet = workbook.createSheet(sheetName);
                    }
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(sheetName);
            }

            int maxColumns = 0;
            for (Row row : sheet) {
                if (row.getPhysicalNumberOfCells() > maxColumns) {
                    maxColumns = row.getPhysicalNumberOfCells();
                }
            }

            for (int i = 0; i < data.size(); i++) {
                Row newRow;
                if (i < sheet.getPhysicalNumberOfRows()) {
                    newRow = sheet.getRow(i);
                    if (newRow == null) {
                        newRow = sheet.createRow(i);
                    }
                } else {
                    newRow = sheet.createRow(i);
                }

                List<String> rowData = data.get(i);
                for (int j = 0; j < rowData.size(); j++) {
                    Cell newCell = newRow.createCell(maxColumns + j);
                    newCell.setCellValue(rowData.get(j));
                }
            }

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to write data to Excel: " + e.getMessage(), e);
        }
    }
}