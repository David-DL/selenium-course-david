package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;


public class LoginPage extends Base{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//objects
	By txtUsername = By.xpath("//input[@name='username']");
	By txtPassword = By.xpath("//input[@name='password']");
	By btnLogin = By.xpath("//button[@type='submit']");
	
	public void enterLoginData() {
		sendText(txtUsername, GlobalVariables.LOGIN_USERNAME);
		sendText(txtPassword, GlobalVariables.LOGIN_PASSWORD);
	}
	
	public void login() {
		click(btnLogin);
	}
	
}
