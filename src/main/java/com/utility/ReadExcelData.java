package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String getParticularRowData(int rownum, int rowvalue) {
		String data = null;
		try {
			File file = new File("C:\\Users\\Devika\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);//upcasting
			Sheet sheet = book.getSheet("Sheet1");
			//Row row =sheet.getRow(4);
			//Cell cell=row.getCell(1);
			Row row =sheet.getRow(rownum);
			Cell cell=row.getCell(rowvalue);
			//String data = cell.getStringCellValue();
			//System.out.println(data);
			DataFormatter dataformat = new DataFormatter();
			data = dataformat.formatCellValue(cell);
			System.out.println(data);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return data;
	}
	/*public static void main(String[] args) {
		//getParticularRowData();
		//getAllData();
		//writeData();
		
	}*/
	public static void getAllData() {
		try {
			File file = new File("C:\\Users\\Devika\\Downloads\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			
			int lastRowCount = sheet.getLastRowNum();
			System.out.println("No of Rows: "+lastRowCount);
			
			short lastCellCount = sheet.getRow(0).getLastCellNum();
			System.out.println("No of Columns: "+lastCellCount);
			
			for (int i = 0; i <= lastRowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j <= lastCellCount; j++) {
					Cell cell = row.getCell(j);
					//Formatting
					DataFormatter dataFormat = new DataFormatter();
					String data = dataFormat.formatCellValue(cell);
					System.out.println(data);
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void writeData() {
		try {
			File file = new File("C:\\Users\\Devika\\Downloads\\DataDriven_IPT.xlsx");
			FileInputStream fileInput = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(fileInput);
			//book.createSheet("FEB_IPT_001").createRow(0).createCell(0).setCellValue("Devika");
			book.getSheet("FEB_IPT_001").createRow(1).createCell(0).setCellValue("Inbha");
			FileOutputStream fileOutput = new FileOutputStream(file);
			book.write(fileOutput);
			System.out.println("------Sucessfully Created------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}






