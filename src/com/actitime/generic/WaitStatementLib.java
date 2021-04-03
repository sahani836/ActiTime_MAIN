package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	
	
	public static void iSleep(int secs)
	
	{
		
		try {
			Thread.sleep(secs*1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/******************************************/
	
	
	public static void iWaitForSecs(WebDriver driver, int secs)
	{
		driver.manage().timeouts().implicitlyWait(secs,TimeUnit.SECONDS);
	}
	
	
	/**********************************************/
	//refresh method does not the whole page just the html code
	
	public static void eWaitForVisibility(WebDriver driver, int secs, WebElement ele)
	{
	
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
		
	}
	
	/****************************************************************/
	//explicit wait till title appears
	public static void eWaitForTitle(WebDriver driver,int secs,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleIs(title)));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
