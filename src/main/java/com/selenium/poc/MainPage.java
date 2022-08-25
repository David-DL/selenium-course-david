package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class MainPage extends Base{
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	//objects
	By labelLoggedIn = By.xpath("//p[@class='oxd-userdropdown-name']");
	By btnAdmin = By.xpath("//ul[@class='oxd-main-menu']//span[text() = 'Admin']");
	By labelAdmin = By.xpath("//div[@class='oxd-topbar-header-title']//h6[text() = 'Admin']");
	By btnAdd = By.xpath("//button//i[contains(@class, 'bi-plus')]");
	By selectUserRole = By.xpath("//label[text() = 'User Role']/parent::div/following-sibling::div");
	By selectStatus = By.xpath("//label[text() = 'Status']/parent::div/following-sibling::div");
	By txtEmpName = By.xpath("//label[text() = 'Employee Name']/parent::div/following-sibling::div//input");
	By txtUsername = By.xpath("//label[text() = 'Username']/parent::div/following-sibling::div//input");
	By labelUsernameAlert = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
	By txtPassword = By.xpath("//label[text() = 'Password']/parent::div/following-sibling::div//input");
	By txtConfirmPassword = By.xpath("//label[text() = 'Confirm Password']/parent::div/following-sibling::div//input");
	By btnSubmit = By.xpath("//button[@type='submit']");
	By txtUserSearch = By.xpath("//label[text() = 'Username']/parent::div/following-sibling::div//input");
	By labelSearchResults = By.xpath("//span[contains(text(),'Records Found')]");
	By btnDeleteItem = By.xpath("//button/*[@class='oxd-icon bi-trash']/parent::button");
	By btnConfirmDelete = By.xpath("//div[@class='orangehrm-modal-footer']/button[2]");
	By loadingSpinner = By.xpath("//div[@class='oxd-loading-spinner']");
	
			
	public boolean verifyLogin() {
		return isDisplayed(labelLoggedIn);
	}
	
	public void clickAdmin() {
		click(btnAdmin);
	}
	
	public boolean verifyAdminSection() {
		return isDisplayed(labelAdmin);
	}
	
	public void clickAdd() {
		click(btnAdd);
	}
	
	public void fillForm(String userRole, String employeeName, String status, String username, String password) {
		By selectUserRoleOpt = By.xpath("//div[@role='option']//span[text()='" + userRole + "']");
		click(selectUserRole);
		click(selectUserRoleOpt);
		
		setImplicitWait(5);
		By employeeOpt = By.xpath("//div[@role='option']//span[contains(text(),'"+ employeeName +"')]");
		sendText(txtEmpName, employeeName);
		click(employeeOpt);
		
		By selectStatusOpt = By.xpath("//div[@role='option']//span[text()='" + status + "']");
		click(selectStatus);
		click(selectStatusOpt);
		
		sendText(txtUsername, username);
		waitForInvisibility(labelUsernameAlert, 5);
		sendText(txtPassword, password);
		sendText(txtConfirmPassword, password);
	}
	
	public void clickSave() {
		click(btnSubmit);
	}
	
	public void enterUserSearch(String username) {
		clearTextBox(txtUserSearch);
		sendText(txtUserSearch, username);
	}

	public void clickSearch() {
		click(btnSubmit);
	}
	
	public boolean isResultVisible(String username) {
		By labelUsernameResult = By.xpath("//div[text()='"+ username +"']");
		return isDisplayed(labelUsernameResult);
	}
	
	public boolean resultIsNotVisible(String username) {
		By labelUsernameResult = By.xpath("//div[text()='"+ username +"']");
		return elementIsNotPresent(labelUsernameResult);
	}
	
	public void deleteFirstResult() {
		click(btnDeleteItem);
	}
	
	public void confirmDeletion() {
		click(btnConfirmDelete);
	}
	
	public void waitForSearchSectionLoad() {
		waitForInvisibility(loadingSpinner, 5);
	}
}
