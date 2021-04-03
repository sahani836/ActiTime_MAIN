package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib 
{
	public WebDriver driver;  //final driver =a
	
	@BeforeMethod
	public void setUp()
	{
		String browserName = GenericLib.getValue("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Reporter.log("Chrome LAunched", true);
			
			
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			
			System.setProperty("webdriver.ie.driver","./exefiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			Reporter.log("IE Launched", true);
			
		}
		
		WaitStatementLib.iWaitForSecs(driver, 20);
		driver.navigate().to(GenericLib.getValue("testurl"));
	}			
		
		
	@AfterMethod 
	public void tearDown(ITestResult result)
	{
		
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess()) //true
		{
			System.out.println("Script Pass");
		}
		else //false
			
		{
			System.out.println(scriptName+"script Failed"); 
			ScreenshotLib slib = new ScreenshotLib();
			slib.takescreenshot(driver, scriptName);
			
		}
		driver.close();
		Reporter.log("Browser closed", true);
		
		
	}
	
}
