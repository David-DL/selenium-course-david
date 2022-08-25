package com.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Base {

	private WebDriver driver;

	/**
	 * Constructor
	 * 
	 * @author David de Leon
	 * 
	 * @param Webdriver
	 * 
	 */

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Chrome driver con
	 * 
	 * @return Chrome driver
	 * 
	 */
	public WebDriver chromeDriverCon() {
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOpt);
		return driver;
	}
	
	/**
	 * Launch browser: Launches a browser instance and navigates to the specified URL.
	 * 
	 * @param URL to navigate to
	 */
	public void launchBrowser(String url) {
		 driver.get(url);
		 driver.manage().window().maximize();
		 setImplicitWait();
	}
	
	/**
	 * Set Implicit wait: Set the implicit wait time in seconds. If no parameters, defaults to 5 seconds.
	 * 
	 * @param seconds
	 */
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void setImplicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	/**
	 * verifyTitleContains: Waits for a specific page to load based on the recognition of the title given in the paramters by name String or the appreance of and specific object..
	 * 
	 * @param title or object
	 */
	public void verifyTitleContains(String titleExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(titleExpected));
	}
	
	/**
	 * waitForVisibility: waits for a specified element to be visible to continue.
	 * 
	 * @param element
	 */
	public void waitForVisibility(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	/**
	 * waitForVisibility: waits for a specified element to be invisible to continue.
	 * 
	 * @param element
	 */
	public void waitForInvisibility(By element, int maxSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, maxSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	/**
	 * elementIsNotPresent: Makes sure an element is not present in the page DOM. Returns true if it's not found and false if it's not.
	 * 
	 * @param element
	 * 
	 * @return false: the element was found in the DOM, true: the element was not found in the DOM.
	 * 
	 */
	public boolean elementIsNotPresent(By element) {
		try {
			driver.findElement(element);
			return false;
		} catch ( org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}
	
	/**
	 * Clear text box: Delete all the text an input element contains.
	 * 
	 * @param element
	 */
	public void clearTextBox(By element) {
		click(element);
		new Actions(driver)
			.keyDown(Keys.CONTROL)
			.sendKeys("a")
			.keyUp(Keys.CONTROL)
			.sendKeys(Keys.DELETE)
			.perform();
	}
	
	/**
	 * Send text: sends text to the element.
	 * 
	 * @param text
	 */
	public void sendText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	/**
	 * Click: Click on an element by its locator.
	 * 
	 * @param element locator
	 */	
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * SetSelector: Select a specific element from a selecto item based on the parameters given.
	 * 
	 * @param element locator, element to select
	 */	
	public void setDropdown(By locator, String element) {
		Select dropdown = (Select) driver.findElement(locator);
		dropdown.selectByValue(element);
	}
	
	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName){
		try {
			String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	/**
	 * Is displayed: Validate if an element is displayed. Returns tru if it is, returns false if not.
	 * 
	 * @param element locator
	 * @return element displayed
	 * 
	 */	
	public boolean isDisplayed(By locator) {
		try {
			driver.findElement(locator).isDisplayed();
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	
	public String getJSONValue(String jsonFileObj, String jsonKey){
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}
	
	/**
	 * Close Browser: closed the active browser instance.
	 */
	public void closeBrowser() {
		driver.close();
	}
	 

}
