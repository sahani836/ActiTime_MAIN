package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenshotLib {
	
	//static method used to take a screenshot
	public void takescreenshot(WebDriver driver, String scriptName)
	{

		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("./screenshot/"+scriptName+".png");
		//here an object is created because we wish to save the screenshot from reference variable srcFile to be saved here
		
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
