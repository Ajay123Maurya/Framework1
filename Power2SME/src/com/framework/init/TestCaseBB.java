package com.framework.init;

import com.framework.result.TestResult;

public class TestCaseBB {
    public String serialNumber;
	public String packageName;
	public String className;
	public String funtionName;
	public String range;
	public String browserChoice;
	public int testIteration;
	public int instance;
	public String testDatasheetPath;
	public String qualifliedClassName;
	public String toolUsed;
	
	public String getToolUsed() {
		return toolUsed;
	}
	public void setToolUsed(String toolUsed) {
		this.toolUsed = toolUsed;
	}
	public String getQualifliedClassName() {
		return qualifliedClassName;
	}
	public void setQualifliedClassName(String qualifliedClassName) {
		this.qualifliedClassName = qualifliedClassName;
	}
	public TestResult[] tr;
	
	public TestResult[] createResultObject(int n) {
		TestResult[] tst=new TestResult[n];
		for(int j=0;j<n;j++) {
			tst[j]=new TestResult();
			
		}
		return tst;
	}
	public TestResult[] getTr() {
		
		return tr;
	}
	public void setTr(TestResult[] tr) {
		this.tr = tr;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getFuntionName() {
		return funtionName;
	}
	public void setFuntionName(String funtionName) {
		this.funtionName = funtionName;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getBrowserChoice() {
		return browserChoice;
	}
	public void setBrowserChoice(String browserChoice) {
		this.browserChoice = browserChoice;
	}
	public int getTestIteration() {
		return testIteration;
	}
	public void setTestIteration() {
		if(getEndRange()==0) {
			this.testIteration = getStartRange()-getEndRange();
		}else {
		this.testIteration = getEndRange()-getStartRange()+1;
		}
	}
	public int getInstance() {
		return instance;
	}
	public void setInstance(int instance) {
		this.instance = instance;
	}
	public String getTestDatasheetPath() {
		return testDatasheetPath;
	}
	public void setTestDatasheetPath(String testDatasheetPath) {
		this.testDatasheetPath = testDatasheetPath;
	}

	public int getStartRange() {
		String r= getRange();
		if(r.contains("-")) {
		String[] a=new String[2];
		a=r.split("-");
		int n=Integer.parseInt(a[0]);
		return n;
		}else {
			int n=Integer.parseInt(r);
			return n;
		}
	}
	public int getEndRange() {
		String r= getRange();
		if(r.contains("-")) {
		String[] a=new String[2];
		a=r.split("-");
		int n=Integer.parseInt(a[1]);
		return n;
		}else {
			return 0;
		}
		
	}
	
}