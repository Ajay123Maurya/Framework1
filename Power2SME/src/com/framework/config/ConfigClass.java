package com.framework.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class ConfigClass {
    public static Date executionStartTime;
	public String driverSheetPath;
	public String driverSheetName;
	public String screenShotPath;
	public String resultFolderPath;
	public int implicitWait;
	public static boolean hiddenmode=false;
	
	public ConfigClass() throws ParserConfigurationException {
		
		executionStartTime=new Date();
		File file = new File("resource/config.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		        
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		try {
			Document document = documentBuilder.parse(file);
			setDriverSheetPath(document.getElementsByTagName("drvsheetpath").item(0).getTextContent());
			setDriverSheetName(document.getElementsByTagName("drvsheetname").item(0).getTextContent());
			setScreenShotPath(document.getElementsByTagName("srcpath").item(0).getTextContent());
			setResultFolderPath(document.getElementsByTagName("rstpath").item(0).getTextContent());
		    String implit= document.getElementsByTagName("implicitWait").item(0).getTextContent();
		    int im=Integer.parseInt(implit);
		    setImplicitWait(im);
		    String mode=document.getElementsByTagName("hiddenMode").item(0).getTextContent();
		    boolean b=Boolean.parseBoolean(mode);
		    setHiddenmode(b);
		   
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getDriverSheetPath() {
		return driverSheetPath;
	}
	public void setDriverSheetPath(String driverSheetPath) {
		this.driverSheetPath = driverSheetPath;
	}
	public String getDriverSheetName() {
		return driverSheetName;
	}
	public void setDriverSheetName(String driverSheetName) {
		this.driverSheetName = driverSheetName;
	}
	public String getScreenShotPath() {
		return screenShotPath;
	}
	public void setScreenShotPath(String screenShotPath) {
		this.screenShotPath = screenShotPath;
	}
	public String getResultFolderPath() {
		return resultFolderPath;
	}
	public void setResultFolderPath(String resultFolderPath) {
		this.resultFolderPath = resultFolderPath;
	}
	public int getImplicitWait() {
		return implicitWait;
	}
	public void setImplicitWait(int implicitWait) {
		this.implicitWait = implicitWait;
	}
	public static boolean isHiddenmode() {
		return hiddenmode;
	}
	public static void setHiddenmode(boolean hiddenmode) {
		ConfigClass.hiddenmode = hiddenmode;
	}
	
	public ArrayList<Integer>  noOfTestcasestobeExecuted() throws IOException  {
		 ArrayList<Integer> arrlist = new ArrayList<Integer>();
		int colNumber=0,totalRows=0;
		FileInputStream inputStream = new FileInputStream(getDriverSheetPath());
		HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
		HSSFSheet sheet =workbook.getSheet(getDriverSheetName());
		HSSFRow firstRow =sheet.getRow(0);
		try {
			
			Iterator<Cell> iterator = firstRow.cellIterator();
			while(iterator.hasNext()) {
				Cell cell =iterator.next();
				if("Execution Flag".equalsIgnoreCase(cell.getStringCellValue())) {
					colNumber=cell.getColumnIndex();
					break;
				}
				
			}
		 totalRows=sheet.getLastRowNum();
		 totalRows--;
		 for(int i=1;i<totalRows;i++) {
			 HSSFRow row =sheet.getRow(i);
			if(row.getCell(colNumber).getStringCellValue().equalsIgnoreCase("yes")) {
			 arrlist.add(i);
			}
		 }
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrlist;
	}
	public ArrayList<String> getTestcaseDetails(int rowno) throws IOException{
		
		ArrayList<String> arrlist = new ArrayList<String>();
		FileInputStream inputStream = new FileInputStream(getDriverSheetPath());
		HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
		HSSFSheet sheet =workbook.getSheet(getDriverSheetName());
		HSSFRow firstRow =sheet.getRow(rowno);
		Iterator<Cell> iterator = firstRow.cellIterator();
		while(iterator.hasNext()) {
			Cell cell =iterator.next();
			if("".equalsIgnoreCase(cell.getStringCellValue())) {
				break;
			}else {
				arrlist.add(cell.getStringCellValue());
			}
			
		}
		return arrlist;
		
	}
}
