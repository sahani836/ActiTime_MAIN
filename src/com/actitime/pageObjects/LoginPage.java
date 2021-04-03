package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	
	
	@FindBy(name="username")
	private WebElement unTxBx;
	@FindBy(name="pwd")
	private WebElement pwdTxBx;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	@FindBy(className="errormsg")
	private WebElement InvalidLoginMsg;
	
	public WebElement getInvalidLoginMsg() {
		return InvalidLoginMsg;
	}


	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this); //initialization
	}
	

	public void login(String username,String password)
	{
		unTxBx.sendKeys("admin");
		pwdTxBx.sendKeys("manager");
		loginBtn.click();
		
		
	}
	
	public void verifyInvalidLogin()
	{
		
		String expMsg = "Username or Password is invalid. Please try again.";
		String actualMsg = InvalidLoginMsg.getText();
		
		
		Assert.assertEquals(actualMsg, expMsg);
		Reporter.log("Invalid Login Msg is displayed", true);
		
		
		
	}
	
}
