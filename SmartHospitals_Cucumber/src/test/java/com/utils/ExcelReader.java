package com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private Workbook workbook;
    private FileInputStream fis;
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
        initializeWorkbook();
    }

    private void initializeWorkbook() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("Excel file not found at: " + filePath);
            }
            this.fis = new FileInputStream(file);
            this.workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Excel workbook: " + e.getMessage(), e);
        }
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        try {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found");
            }
            
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return "";
            }
            
            Cell cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (cell == null) {
                return "";
            }
            
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            throw new RuntimeException("Error getting cell data: " + e.getMessage(), e);
        }
    }

    public static Map<String, String> getPatientAppointmentForm(String filePath, String sheetName) {
        Map<String, String> appointmentData = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found");
            }
            
            DataFormatter formatter = new DataFormatter();
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(1);
            
            if (headerRow != null && dataRow != null) {
                for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                    String header = formatter.formatCellValue(headerRow.getCell(i));
                    String value = formatter.formatCellValue(dataRow.getCell(i));
                    appointmentData.put(header, value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read appointment form: " + e.getMessage(), e);
        }
        return appointmentData;
    }
	public static Map<String, String> getPatientAppointmentForm(String filePath, String sheetname) {
		Map<String , String > appointmentData = new HashMap<>();
		DataFormatter formatter = new DataFormatter();
		
		try {
			File file = new File(filePath);
			FileInputStream fileIn = new FileInputStream(file);
			
			XSSFWorkbook workbook = new XSSFWorkbook (fileIn);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			
			XSSFRow header = sheet.getRow(0);
			XSSFRow row = sheet.getRow(1);
			
			for(int i = 0 ; i < header.getLastCellNum() ; i++) {
				String head = formatter.formatCellValue(header.getCell(i));
				String rowData = formatter.formatCellValue(row.getCell(i));
				appointmentData.put(head, rowData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return appointmentData;
	}
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing Excel resources: " + e.getMessage());
        }
    }
}