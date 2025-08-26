package com.ePRIME.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ePRIME.TestBase.BaseClass;
import com.ePRIME.TestUtility.DriverUtility;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//select[@name='login_type']")
	private WebElement roleDropdown;
	
	@FindBy(xpath = "//input[@name='email'][@type='text']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space(text())='Account']")
	private WebElement accountDropdown;
	
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutButton;
	
	
	public void verifyLogin(String value,String emailId,String password)
	{
		selectRoleDropdown(value);
		
		enterEmailField(emailId);
		
		enterPasswordField(password);
		
		clickLoginButton();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clickAccountDropdown();
		
		clickLogoutButton();
	}
	
	public void selectRoleDropdown(String value)
	{
		DriverUtility.dropdownByVisibleText(roleDropdown, value);
	}
	
	public void enterEmailField(String emailId)
	{
		DriverUtility.enterValueOnElement(emailField, emailId);
	}
	
	public void enterPasswordField(String password)
	{
		DriverUtility.enterValueOnElement(passwordField, password);
	}
	
	public void clickLoginButton()
	{
		DriverUtility.clickElement(loginButton);
	}
	
	public void clickAccountDropdown()
	{
		DriverUtility.clickElement(accountDropdown);
	}
	
	public void clickLogoutButton()
	{
		DriverUtility.clickElement(logoutButton);
	}
}
