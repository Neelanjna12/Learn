package com.restAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {

	static FileInputStream fis;
	static XSSFWorkbook wb;
	FileOutputStream fos;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;

	@Test
	static int rowCount(String file, String sheetName) throws IOException {
		fis = new FileInputStream(new File(file));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}

	@Test
	static int columCount(String file, String sheetName, int rowCount) throws IOException {
		fis = new FileInputStream(new File(file));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int columnCount = sheet.getRow(0).getLastCellNum();
		wb.close();
		fis.close();
		return columnCount;

	}

	@Test
	 static String fethCellData(String file, String sheetName, int rowIndex, int columnIndex) throws IOException {
		fis = new FileInputStream(new File(file));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		cell = row.getCell(columnIndex);
		wb.close();
		fis.close();
		DataFormatter data = new DataFormatter();
		String CellData = data.formatCellValue(cell);
		return CellData;
	}

	@Test
	void writeCellData(String file, String sheetName, int rowIndex, int columnIndex, String data) throws IOException {
		fis = new FileInputStream(new File(file));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		cell = row.createCell(columnIndex);
		cell.setCellValue(data);
		fos = new FileOutputStream(new File(file));
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

}
