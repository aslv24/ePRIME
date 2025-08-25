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
	
	@FindBy(xpath = "//button[@type='subm']")
	private WebElement loginButton;
	
	public void verifyLogin(int index,String emailId,String password)
	{
		selectRoleDropdown(index);
		
		enterEmailField(emailId);
		
		enterPasswordField(password);
		
		clickLoginButton();
	}
	
	public void selectRoleDropdown(int index)
	{
		DriverUtility.dropdownByIndex(roleDropdown, index);
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
}
