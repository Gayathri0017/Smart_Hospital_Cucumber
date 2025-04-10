package com.utils;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
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
}