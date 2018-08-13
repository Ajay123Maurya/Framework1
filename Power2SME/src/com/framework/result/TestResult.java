package com.framework.result;

public class TestResult {

	public String status;
	public String PassMessage;
	public String failedMessage;
	public String skipMessage;
	public long executionTime;
	public String testData;
	public int rangeResult;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassMessage() {
		return PassMessage;
	}
	public void setPassMessage(String passMessage) {
		this.PassMessage = passMessage;
	}
	public String getFailedMessage() {
		return failedMessage;
	}
	public void setFailedMessage(String failedMessage) {
		this.failedMessage = failedMessage;
	}
	public String getSkipMessage() {
		return skipMessage;
	}
	public void setSkipMessage(String skipMessage) {
		this.skipMessage = skipMessage;
	}
	public long getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	public String getTestData() {
		return testData;
	}
	public void setTestData(String testData) {
		this.testData = testData;
	}
	public int getRangeResult() {
		return rangeResult;
	}
	public void setRangeResult(int rangeResult) {
		this.rangeResult = rangeResult;
	}
	
	
	
}
