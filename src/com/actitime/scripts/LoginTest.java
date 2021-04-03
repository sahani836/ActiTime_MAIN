package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.generic.WaitStatementLib;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;

 class LoginTest extends BaseLib{
	
	@Test
	public void validLogin()
	{
		String username = ExcelUtilities.readData("Sheet1", 1, 1);
		String password = ExcelUtilities.readData("sheet1", 1, 2);
		LoginPage lp =new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
		ettp.verifylogo();
		ettp.verifyTitle();
		
		
	}

//	@Test
//	public void InvalidLogin()
//	{
//		String username = ExcelUtilities.readData("Sheet1", 2, 1);
//		String password = ExcelUtilities.readData("sheet1", 2, 2);
//		LoginPage lp =new LoginPage(driver);
//		WaitStatementLib.eWaitForVisibility(driver, 20, lp.getInvalidLoginMsg());
//		
//		lp.login(username, password);
//		
//		lp.verifyInvalidLogin();
//	
//	
//	
	}
	

