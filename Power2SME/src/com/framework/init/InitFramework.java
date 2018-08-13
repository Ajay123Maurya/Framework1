package com.framework.init;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;

import com.framework.config.ConfigClass;
import com.framework.result.HTMLResult;
import com.framework.result.TestResult;
import com.framework.reusables.TestCaseSetup;
import com.framework.reusables.TestUtility;

public class InitFramework {
	ConfigClass var;
	Connection con=null;
	PreparedStatement ps=null,ps1=null;
	public static boolean browserLaunchControl=false;
	Logger logger=Logger.getLogger(InitFramework.class);
    public static int currentIteration=0;
	public void init() throws Exception {
		try {
			var=new ConfigClass();
			logger.info("Starting the framework");
			if(!isFolderPresent(var.getDriverSheetPath())) {
				logger.info("Driver Sheet Not Found throwing error");
				throw  new FileNotFoundException(var.getDriverSheetPath()+ ".....File not present");
			}else {
				logger.info("Driver Sheet Found started reading-----");
				
			}
/*			// Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
		     //   con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver(*.xls)};DBQ="+var.driverSheetPath+";READONLY=false");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
           // con =DriverManager.getConnection("jdbc:ucanaccess://"+var.getDriverSheetPath()+"");
			  con = DriverManager.getConnection("jdbc:ucanaccess://"+var.getDriverSheetPath()+";jackcessOpener=com.framework.init.CryptCodecOpener", "", "");
			//  con=DriverManager.getConnection("jdbc:ucanaccess://"+var.getDriverSheetPath()+"", "", "");
			//    PreparedStatement ps=con.prepareStatement("");
        //    PreparedStatement ps1=con.prepareStatement("");
*/		 ArrayList<Integer> arrlist = new ArrayList<Integer>();
			 arrlist=var.noOfTestcasestobeExecuted();
			int totalTestcaseCount=arrlist.size();
			logger.info("Total no of testcase to be execute  - " +totalTestcaseCount);
			TestCaseBB[] tc=new TestCaseBB[totalTestcaseCount];
			for(int i=0;i<totalTestcaseCount;i++) {
				tc[i]=new TestCaseBB();
				 ArrayList<String> strlist = new ArrayList<String>();
				 strlist=var.getTestcaseDetails(arrlist.get(i));
				tc[i].setSerialNumber(strlist.get(0));
				tc[i].setPackageName(strlist.get(1));
				tc[i].setClassName(strlist.get(2));
				tc[i].setFuntionName(strlist.get(3));
				tc[i].setRange(strlist.get(4));
				tc[i].setBrowserChoice(strlist.get(5));
				tc[i].setTestDatasheetPath(strlist.get(7));
				tc[i].setTestIteration();
				tc[i].setToolUsed(strlist.get(8));
			}
			
			for(int m=0;m<tc.length;m++) {
			tc[m].setTr(startRangeExecution(tc[m]));
			}
			HTMLResult ht=new HTMLResult();
			ht.startPrintResult(tc);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TestResult[] startRangeExecution(TestCaseBB tc) {
		int n=tc.getTestIteration();
		TestResult[] tst=new TestResult[n];
	    tst=tc.createResultObject(n);
		currentIteration=0;
		for(int k=0;k<n;k++) {
			currentIteration=k+1;
			try {
				tst[k]=startExecution(tc);
				
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return tst;
	}
	

	public TestResult startExecution(TestCaseBB tc) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		TestResult tr=new TestResult();
		TestUtility utility=new TestUtility();
		long startTime = 0,endTime=0;
		
		String st=tc.getPackageName();
		String str=st+".";
		tc.setQualifliedClassName(str+tc.getClassName());
		try {
			Class<?> paramType[] = null;
			Object _classObj = null,paramVal[] = null;
			Class<?>   _class=Class.forName(tc.getQualifliedClassName());
			_classObj=_class.newInstance();
			Method  method = _class.getDeclaredMethod (tc.getFuntionName(), paramType);
		logger.info("Started excecution of class - "+tc.getQualifliedClassName());
		startTime =System.currentTimeMillis();
		if(tc.getToolUsed().equalsIgnoreCase("Browser")) {
	     utility.launchBrowser(tc.getBrowserChoice());
		}
		 utility.setCurrentIteration(currentIteration);
		   utility.setTestDataSheetPath(tc.getTestDatasheetPath());
		   logger.info("Invoking method - " +tc.getFuntionName());
		   TestCaseSetup.setUtility(utility);
		   method.invoke(_classObj, paramVal);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			tr.setStatus("Failed");
			 tr.setFailedMessage("Test has been failed");
			e.printStackTrace();
		}
		endTime=System.currentTimeMillis();
		TestCaseSetup.getTestresult().setExecutionTime(endTime-startTime);
		TestCaseSetup.getTestresult().setRangeResult(currentIteration);
		if(TestCaseSetup.getTestresult().getStatus()==null) {
			TestCaseSetup.getTestresult().setStatus("Failed");
			 tr.setFailedMessage("Test has been failed");
		}
		tr = TestCaseSetup.getTestresult();
		return tr;
	}
	public boolean isFolderPresent(String filePath) {
		
	String _path = filePath.replaceAll("\\s+", "");
	File f= new File(_path);
	return f.exists();
	}
	
}
