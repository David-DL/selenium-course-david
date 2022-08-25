package com.selenium.test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.MainPage;
import com.selenium.poc.LoginPage;

public class POMTestCases{
	
	
	WebDriver driver;
	Base base;
	LoginPage loginPage;
	MainPage mainPage;
	
	//Testing data variables
	String userRole;
	String employeeName;
	String status;
	String username;
	String password;
	
	ExtentReports extent;
	ExtentTest logger;
	private String className = this.getClass().getSimpleName();
	
	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverCon();
		
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		
		java.util.Date date = new java.util.Date();
		
		userRole = base.getJSONValue("TC1", "userRole");
		employeeName = base.getJSONValue("TC1", "employeeName");
		status = base.getJSONValue("TC1", "status");
		username = base.getJSONValue("TC1", "username")  + " " + date;
		password = base.getJSONValue("TC1", "password");
		
		//Extent setup
		extent = new ExtentReports(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.REPORT_PATH, true);
		extent.addSystemInfo(GlobalVariables.EXTENT_QA_URL, GlobalVariables.QA_URL);
		extent.loadConfig(new File(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.CONFIG_EXTENT));
	}
	
	@Test
	public void testCase1() {
		
		// Extent start
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		
		//Step 1: Launch browser
		base.launchBrowser(GlobalVariables.QA_URL);
		
		//Step 2: Enter data to login
		loginPage.enterLoginData();
		
		//Step 3: Login
		loginPage.login();
		
		//Step 4: Validate login
		mainPage.verifyLogin();
		
		//Step 5: Click admin module
		mainPage.clickAdmin();
		
		//Step 6: Admin page is displayed
		mainPage.verifyAdminSection();
		
		//Step 7: Click add
		mainPage.clickAdd();
		
		//Step 8: Fill out the form to create the user
		mainPage.fillForm(userRole, employeeName, status, username, password);
		
		//Step 9:Click on save
		mainPage.clickSave();
		
		//Step 10: Insert user just created into the username textbox
		mainPage.waitForSearchSectionLoad();
		mainPage.enterUserSearch(username);
		
		//Step 11: Click search
		mainPage.clickSearch();
		
		//Step 12: Validate the user exist in the result table after search
		Assert.assertTrue(mainPage.isResultVisible(username));
		
		//Step 13: Select user in the table result and click delete
		mainPage.deleteFirstResult();
		
		//Step 14: Click Ok to confirm deletion
		mainPage.confirmDeletion();
		
		//Step 15: Validate user was deleted successfully
		mainPage.enterUserSearch(username);
		mainPage.clickSearch();
		Assert.assertTrue(mainPage.resultIsNotVisible(username));
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("fail")));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
		base.closeBrowser();

	}


}
