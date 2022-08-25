package com.selenium.activities.Ejercicio7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio7 {

	public static void main(String[] args) {
		ChromeOptions chromeOpt  = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(chromeOpt);
		
		driver.get("https://computer-database.gatling.io/computers");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.titleContains("Computers database"));
		
		driver.findElement(By.id("add")).click();
		driver.findElement(By.id("name")).sendKeys("David's Computer");
		driver.findElement(By.id("introduced")).sendKeys("2020-08-14");
		driver.findElement(By.id("discontinued")).sendKeys("2100-08-14");
		Select companyPicklist = new Select(driver.findElement(By.id("company")));
		companyPicklist.selectByVisibleText("Amiga Corporation");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();

	}

}
