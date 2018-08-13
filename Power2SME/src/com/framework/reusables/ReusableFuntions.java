package com.framework.reusables;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReusableFuntions {

	@SuppressWarnings("resource")
	public String getColumnDataByRowno(String filePath,String sheetName,String columnName,int rowno) throws Exception {
		int colNumber=0;
		String data=null;
		try {
			FileInputStream inputStream=new FileInputStream(filePath);
			HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
			HSSFSheet sheet =workbook.getSheet(sheetName);
			HSSFRow firstRow =sheet.getRow(0);
			Iterator<Cell> iterator = firstRow.cellIterator();
			while(iterator.hasNext()) {
				Cell cell =iterator.next();
				if(columnName.equalsIgnoreCase(cell.getStringCellValue())) {
					colNumber=cell.getColumnIndex();
					break;
				}
				
			}
			HSSFRow row=sheet.getRow(rowno);
			 data =row.getCell(colNumber).getStringCellValue();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@SuppressWarnings("resource")
	public void writeResultIntoColumn(String filePath,String sheetName,String columnName,String data,int rowno) throws Exception {
		int colNumber=0;
		try {
			FileInputStream inputStream=new FileInputStream(filePath);
			HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
			HSSFSheet sheet =workbook.getSheet(sheetName);
			HSSFRow firstRow =sheet.getRow(0);
			Iterator<Cell> iterator = firstRow.cellIterator();
			while(iterator.hasNext()) {
				Cell cell =iterator.next();
				if(columnName.equalsIgnoreCase(cell.getStringCellValue())) {
					colNumber=cell.getColumnIndex();
					break;
				}
				
			}
			HSSFRow row=sheet.getRow(rowno);
			row.createCell(colNumber).setCellValue(data);
			inputStream.close();
			FileOutputStream outputStream =new FileOutputStream(filePath);
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
