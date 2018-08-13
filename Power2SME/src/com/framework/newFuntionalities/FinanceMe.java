package com.framework.newFuntionalities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.framework.result.TestResult;
import com.framework.reusables.ConfigFile;
import com.framework.reusables.TestCaseSetup;

public class FinanceMe extends TestCaseSetup {
	ConfigFile cf=new ConfigFile();
    TestResult tr = new TestResult();
    public String sheetName;
    Logger logger=Logger.getLogger(getClass());
	public void login(String sheetName) throws Exception {
		driver.manage().window().maximize();
		driver.get(cf.financeMeUrl);
		driver.findElement(By.id("login")).click();
			driver.findElement(By.id("mobile")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Username", utility.getCurrentIteration()));
			driver.findElement(By.cssSelector("[name='your_password']")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Password", utility.getCurrentIteration()));
			driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[2]/div/div/form/div/button")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
	}
	public void sales() {
		sheetName=cf.F_sales;
		
		try {
			this.login(sheetName);
		    this.fillAccountDetails(sheetName);
			
			tr.setStatus("Passed");
	        tr.setPassMessage("Test has been passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tr.setStatus("Failed");
			 tr.setFailedMessage("Test has been failed");
			e.printStackTrace();
		}

        TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}
	public void fillAccountDetails(String sheetName) throws Exception {
		logger.info("Searching for  a SME");
		//type the pan
		driver.findElement(By.xpath(".//*[@id='tab1']/div[1]/div/div[1]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Pan", utility.getCurrentIteration()));
		//Click on search button
		driver.findElement(By.xpath(".//*[@id='tab1']/div[1]/div/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click on initiate loan
		driver.findElement(By.xpath(".//*[@id='dialogContent_0']/div/md-dialog-actions[2]/primary-button[1]")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		logger.info("Filling  personal  contact information");
		//-------------Personal Contact Information------------------------
		//Type the first name
		driver.findElement(By.id("personalname")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "First Name", utility.getCurrentIteration()));
		//Type  last name
		driver.findElement(By.id("personalnamelast")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Last Name", utility.getCurrentIteration()));
		//Type email address
		driver.findElement(By.id("personalemail")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Email ID", utility.getCurrentIteration()));
		//Type phone  number
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div/div[1]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Phone number", utility.getCurrentIteration()));
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Type alternate number
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Alternate number", utility.getCurrentIteration()));
		//Type  address
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[1]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Address", utility.getCurrentIteration()));
		//Select state
	    new Select(driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[3]/div[2]/select"))).selectByVisibleText(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "State", utility.getCurrentIteration()));	
	   //Select city.//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[3]/div/div[2]/div/div[3]/div[1]/input
	    new Select(driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[3]/div[3]/select"))).selectByVisibleText(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "City", utility.getCurrentIteration()));
	  //Type Pincode
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[3]/div[1]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Pin code", utility.getCurrentIteration()));
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 
		 logger.info("Filling comapany contact information");
		//------------------Company contact information ----------------------------
	    //Type company name
		driver.findElement(By.id("companyname")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Company name", utility.getCurrentIteration()));
		//Type company email address
		driver.findElement(By.id("companyemail")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Comany Email", utility.getCurrentIteration()));
		//Type company phone number
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Phone number", utility.getCurrentIteration()));
		//Type company alternate number
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Alternate number", utility.getCurrentIteration()));
		//Type company address
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[2]/div/div[2]/div[3]/div/div[2]/div/div[1]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Address", utility.getCurrentIteration()));
		//Select state
	    new Select(driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[2]/div/div[2]/div[3]/div/div[2]/div/div[4]/select"))).selectByVisibleText(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "State", utility.getCurrentIteration()));	
	   //Select city
	    new Select(driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[2]/div/div[2]/div[3]/div/div[2]/div/div[5]/select"))).selectByVisibleText(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "City", utility.getCurrentIteration()));
	  //Type Pincode
		driver.findElement(By.xpath(".//*[@id='PersonalProfileForm']/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div[3]/input")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), sheetName, "Pin code", utility.getCurrentIteration()));
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("[value='Save']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
/*	public void finance() {
		sheetName=cf.F_finance;
		this.login(sheetName);
		tr.setStatus("Passed");
        tr.setPassMessage("Test has been passed");
        TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}
	public void SCM() {
		sheetName=cf.F_SCM;
		this.login(sheetName);
		tr.setStatus("Passed");
        tr.setPassMessage("Test has been passed");
        TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}
	public void salesView() {
		sheetName=cf.F_Sales_View;
		this.login(sheetName);
		tr.setStatus("Passed");
        tr.setPassMessage("Test has been passed");
        TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}
	public void auditor() {
	sheetName=cf.F_Auditors;
	this.login(sheetName);
	tr.setStatus("Passed");
    tr.setPassMessage("Test has been passed");
    TestCaseSetup.setTestresult(tr);	
	driver.quit();
	}
	public void nbfc() {
		sheetName=cf.F_NBFC_Details;
		this.login(sheetName);
		tr.setStatus("Passed");
        tr.setPassMessage("Test has been passed");
        TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}
	public void finance2() {
		sheetName=cf.F_finance2;
		this.login(sheetName);
		tr.setStatus("Passed");
        tr.setPassMessage("Test has been passed");
        TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}*/
}
