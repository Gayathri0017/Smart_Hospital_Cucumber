package com.utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
public class ExcelReader {
    Workbook workbook;
    public ExcelReader(String path){
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            workbook=WorkbookFactory.create(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getCellData(String sheetName,int row,int col) {
        return workbook.getSheet(sheetName).getRow(row).getCell(col).toString();
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
}