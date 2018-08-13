package com.framework.newFuntionalities;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.framework.result.TestResult;
import com.framework.reusables.ConfigFile;
import com.framework.reusables.TestCaseSetup;

public class NBFC extends TestCaseSetup{
    ConfigFile cf=new ConfigFile();
    TestResult tr = new TestResult();
	public void login() {
		driver.get(cf.url);
		try {
			driver.findElement(By.cssSelector("[name='username']")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), cf.N_1, "Username", utility.getCurrentIteration()));
			driver.findElement(By.cssSelector("[name='password']")).sendKeys(getColumnDataByRowno(utility.getTestDataSheetPath(), cf.N_1, "Password", utility.getCurrentIteration()));
			driver.findElement(By.cssSelector("[type='submit']")).click();
			tr.setStatus("Passed");
            tr.setPassMessage("Test has been passed");
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tr.setStatus("Failed");
            tr.setPassMessage("Test has been failed");
            
		}
		TestCaseSetup.setTestresult(tr);	
    	driver.quit();
	}
	public void keyboardLogin() throws AWTException {
		driver.get(cf.url);
//		TestCaseSetup.robot.useKeyboardClickSpecialButton("Ctrl");
//		TestCaseSetup.robot.useKeyboardClickSpecialButton("Alt");
//		TestCaseSetup.robot.useKeyBoardGetText('t');
//		TestCaseSetup.robot.useKeyboardReleaseSpecialButton("Ctrl");
//		TestCaseSetup.robot.useKeyboardReleaseSpecialButton("Alt");
		TestCaseSetup.robot.useKeyboardPrintWord("BI00469");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		TestCaseSetup.robot.useKeyboardClickSpecialButton("Tab");
		TestCaseSetup.robot.useKeyboardReleaseSpecialButton("Tab");
		TestCaseSetup.robot.useKeyboardPrintWord("888888");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		TestCaseSetup.robot.useKeyboardClickSpecialButton("Enter");
		TestCaseSetup.robot.useKeyboardReleaseSpecialButton("Enter");
		//TestCaseSetup.robot.useKeyboardClickSpecialButton("Ctrl");
		//TestCaseSetup.robot.useKeyboardClickSpecialButton("Shift");
    	//TestCaseSetup.robot.useKeyBoardGetText('q');
		
		tr.setStatus("Passed");
        tr.setPassMessage("Test has been passed");
        TestCaseSetup.setTestresult(tr);
	}
}
