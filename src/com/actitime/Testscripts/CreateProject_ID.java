package com.actitime.Testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageObjects.CreateProject_Page;
import com.actitime.pageObjects.LoginPage;

public class CreateProject_ID extends BaseLib{ 

private static final String ProjectName = null;
private static final String ProjectDes1 = null;

@Test
public void createProject()
{
	
	String username =  ExcelUtilities.readData("Sheet1", 1, 1);
	String password =  ExcelUtilities.readData("Sheet1", 2, 2);
	//String ProjectName =  ExcelUtilities.readData("Sheet1", 5, 5);
	LoginPage lp =new LoginPage(driver);
	lp.login(username, password);
	CreateProject_Page createPr= new CreateProject_Page(driver);
	createPr.clickOnTask();
	createPr.clickOnProjAndCustLink();
	createPr.CreateNewProjectMethod();
	Select drpCountry = new Select(driver.findElement(By.name("customerId")));
	drpCountry.selectByVisibleText("GE HealthCare");
	createPr.ProjectName(ProjectName, ProjectDes1);
	createPr.CreateProject();
	
}
}