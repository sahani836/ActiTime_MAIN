package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	
	//@FindBy(css="img[src*='']")
	@FindBy(xpath=".//*[@id='topnav']/tbody/tr[1]/td[1]/div/div[3]/img")
	private WebElement logo;
	
	@FindBy(xpath="//a[@href='/tasks/otasklist.do']")
	private WebElement tasks;
	
	@FindBy(id="logoutLink")private WebElement logoutBtn;
	
	public BasePage(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifylogo()
	{
		Assert.assertTrue(logo.isDisplayed());
		Reporter.log("Logo is verified", true);
	
	
	}
	
	public void clickOnTasks()
	{
		tasks.click();
		
	}
	
	public void clickOnLogout()
	{
		logoutBtn.click();
	}
	
}
