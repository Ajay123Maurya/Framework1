package com.framework.reusables;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.config.ConfigClass;


public class TestUtility {
 
	public int currentIteration;
	public String TestDataSheetPath;
	Logger logger=Logger.getLogger(TestUtility.class);
	public int getCurrentIteration() {
		return currentIteration;
		
	}
	public boolean launchBrowser(String browserChoice) {
		boolean flag =false;
		switch(browserChoice) {
		case "mozzila":
			logger.info("Launching browser - Mozzila firefox");
			System.setProperty("webdriver.firefox.marionette","/home/ajaykumar/Selenium_Drivers/geckodriver");
			TestCaseSetup.driver = new FirefoxDriver();
			if(ConfigClass.isHiddenmode()) {
			TestCaseSetup.driver.manage().window().setPosition(new Point(-2000, 0));
			}
			flag=true;
			break;
		case "chrome":
			File file =new File("/home/ajaykumar/Selenium_Drivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-infobar");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            TestCaseSetup.driver = new ChromeDriver(capabilities);
            flag=true;
            break;
		case "IE":
			System.setProperty("webdriver.ie.driver","Path of IE driver");
			TestCaseSetup.driver = new InternetExplorerDriver();
			flag=true;
			break;
			
		
		}
		return flag;
	}
	
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		 
	         TakesScreenshot scrShot =((TakesScreenshot)webdriver);
             File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
             File DestFile=new File(fileWithPath);
             FileUtils.copyFile(SrcFile, DestFile);

	    }

	public void setCurrentIteration(int currentIteration) {
		this.currentIteration = currentIteration;
	}
	public String getTestDataSheetPath() {
		return TestDataSheetPath;
	}
	public void setTestDataSheetPath(String testDataSheetPath) {
		TestDataSheetPath = testDataSheetPath;
	}
	
}
