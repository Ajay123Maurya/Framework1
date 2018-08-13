package com.framework.reusables;

import org.openqa.selenium.WebDriver;

import com.framework.result.TestResult;
import com.framework.robot.KeyboardRobot;

public class TestCaseSetup extends ReusableFuntions{

	public static  WebDriver driver;
	public static TestResult testresult;
	public static TestUtility utility;
	public static KeyboardRobot robot=new KeyboardRobot();
	
	public static KeyboardRobot getRobot() {
		return robot;
	}
	public static void setRobot(KeyboardRobot robot) {
		TestCaseSetup.robot = robot;
	}
	public static TestResult getTestresult() {
		return testresult;
	}
	public static void setTestresult(TestResult testresult) {
		
		TestCaseSetup.testresult = testresult;
	}
	public static TestUtility getUtility() {
		return utility;
	}
	public  static void setUtility(TestUtility utility) {
		TestCaseSetup.utility = utility;
	}
	
	
}
