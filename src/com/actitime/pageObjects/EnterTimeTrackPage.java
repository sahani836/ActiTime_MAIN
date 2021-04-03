package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage
{
	WebDriver driver;//c
	public EnterTimeTrackPage(WebDriver driver)//b
	{
		super(driver);	// driver of entertimetrackpage will call driver of driver of base page as base class is super class of entertimetrackpage
		this.driver=driver;	//c=b
	}
	public void verifyTitle()
	{
		String expTitle = "actiTIME - Enter Time-Track";
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Home page title is verified",true);
	}
	
}
