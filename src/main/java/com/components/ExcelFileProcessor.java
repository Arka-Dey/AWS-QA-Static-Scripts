package com.components;

import com.baseClasses.BaseClass_Web;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;


public class ExcelFileProcessor extends BaseClass_Web {
	
	public static void inputValueIntoB7(String filePath, String sheetName, int value) throws IOException {
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet with name '" + sheetName + "' does not exist.");
	        }
	        Row row = sheet.getRow(6);
	        if (row == null) {
	            row = sheet.createRow(6);
	        }
	        Cell cell = row.getCell(1);
	        if (cell == null) {
	            cell = row.createCell(1);
	        }
	        cell.setBlank();
	        cell.setCellValue(value);
	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            workbook.write(fos);
	        }
	    }
	}
	
}
