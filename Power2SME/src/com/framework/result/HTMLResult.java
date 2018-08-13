package com.framework.result;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;

import com.framework.config.ConfigClass;
import com.framework.init.TestCaseBB;

public class HTMLResult {
    ConfigClass cf;
	PrintStream out;
	public String backGroundColor="#FFE4C4";
	public String tableHeaderColor="#D2691E";
	public int failCount=0,passCount=0,skipCount=0,totalCount=0;
	public long totalExecutionTime=0;
	Logger logger=Logger.getLogger(getClass());
	public void startPrintResult(TestCaseBB tc[]) throws IOException, ParserConfigurationException {
	        this.setUpData(tc);
	        this.testExecutionInfo();
	        this.testExecutionSummary();
	        this.testExecutionDetail(tc);
	        
	        try {
				cf=new ConfigClass(); 
				 File file =new File(cf.getResultFolderPath()+ "/result.html");
				 Desktop.getDesktop().open(file);
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	}
	public void setUpData(TestCaseBB tc[]) {
		for(TestCaseBB t:tc) {
			for(TestResult tr:t.getTr()) {
				if(tr.getStatus().equalsIgnoreCase("Passed")) {
					passCount++;
					totalExecutionTime=totalExecutionTime+tr.getExecutionTime();
				}else if(tr.getStatus().equalsIgnoreCase("Failed")) {
					failCount++;
					totalExecutionTime=totalExecutionTime+tr.getExecutionTime();
				}else {
					skipCount++;
					totalExecutionTime=totalExecutionTime+tr.getExecutionTime();
				}
			}
		}
		totalCount=passCount+failCount+skipCount;
	}
	public void testExecutionInfo() throws FileNotFoundException, ParserConfigurationException {
		cf=new ConfigClass(); 
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		String part[]=timeStamp.split("_");
		String dateOfExecution=part[0];
	    String timeOfExecution=part[1];
		out=new PrintStream(new FileOutputStream(cf.getResultFolderPath()+ "/result.html"));
		logger.info("Printing the test result");
		out.println("<html><head><title>TestSheet Result</title></head><body bgcolor="+backGroundColor+">");
		out.println("<div align=center><caption><h3>Test Execution Information<h3></caption>");
		out.println("<table border='1' border-collapse='collapse' align=center>");
		out.println("<tr align=center><td><b>TestCase Sheet Path</b></td><td>"+cf.getDriverSheetPath()+"</td></tr>");
		out.println("<tr align=center><td><b>TestCase Sheet Name</b></td><td>"+cf.getDriverSheetName()+"</td></tr>");
		
	    out.println("<tr align=center><td><b>Date of Execution</b></td><td>"+dateOfExecution+"</td></tr>");
		out.println("<tr align=center><td><b>Time of Execution</b></td><td>"+timeOfExecution+"</td></tr>");
		out.println("<tr align=center><td><b>Total time taken</b></td><td>"+totalExecutionTime/1000+" Second</td></tr></table></div>");
		out.println("<div align=center><caption><h3>************************************************************************************</h3></caption></div>");
	}
	public void testExecutionSummary() {
		out.println("<div align=center><caption><h3>Test Execution Summary</h3></caption>");
		out.println("<table border='1' border-collapse='collapse' align=center>");
		out.println("<tr align=center><td><b>Total TestCase Executed</b></td><td>"+totalCount+"</td></tr>");
		out.println("<tr align=center><td><b>Total TestCase Passed</b></td><td>"+passCount+"</td></tr>");
		out.println("<tr align=center><td><b>Total TestCase Failed</b></td><td>"+failCount+"</td></tr>");
		out.println("<tr align=center><td><b>Total TestCase Skipped</b></td><td>"+skipCount+"</td></tr></table></div>");
		out.println("<div align=center><caption><h3>************************************************************************************</h3></caption></div>");
	}
   public void testExecutionDetail(TestCaseBB tc[]) {
	   out.println("<div align=center><caption><h3>Test Execution Details<h3></caption>");
	   out.println("<table border='1' border-collapse='collapse' align=center>");
	   out.println("<tr align=center ><td bgcolor="+tableHeaderColor+" width='30%'>Qualified Class Name</td><td  bgcolor="+tableHeaderColor+"  width='20%'>Funtion Name</td><td bgcolor="+tableHeaderColor+ " width='15%'>Iteration Details</td><td bgcolor="+tableHeaderColor+" width='10%'>Execution Time</td><td bgcolor="+tableHeaderColor+" width='10%'>Status</td><td bgcolor="+tableHeaderColor+" width='40%'>Description</td></tr>");
	 for(TestCaseBB t:tc) {
		
		 for(TestResult tr:t.getTr()) {
			 if("Passed".equalsIgnoreCase(tr.getStatus())) {
			 out.println("<tr><td>"+t.getQualifliedClassName()+"</td><td>"+t.getFuntionName()+"</td><td>ITERATION - "+tr.getRangeResult()+"</td><td>"+tr.getExecutionTime()/1000+" Second</td><td bgcolor= '#006400'>"+tr.getStatus()+"</td><td>"+tr.getPassMessage()+"</td>");
			 }
			 else if("Failed".equalsIgnoreCase(tr.getStatus())) {
				 out.println("<tr><td>"+t.getQualifliedClassName()+"</td><td>"+t.getFuntionName()+"</td><td>ITERATION - "+tr.getRangeResult()+"</td><td>"+tr.getExecutionTime()+"</td><td  bgcolor='#FF0000'>"+tr.getStatus()+"</td><td>"+tr.getFailedMessage()+"</td>");
				 }else {
					 out.println("<tr><td>"+t.getQualifliedClassName()+"</td><td>"+t.getFuntionName()+"</td><td>ITERATION - "+tr.getRangeResult()+"</td><td>"+tr.getExecutionTime()+"</td><td bgcolor= '#1E90FF'>"+tr.getStatus()+"</td><td>"+tr.getFailedMessage()+"</td>");
					 
				 }
			 }
	 }
	 out.println("</table></div></body></html>");
   }
}
