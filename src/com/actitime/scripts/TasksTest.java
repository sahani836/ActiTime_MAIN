package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageObjects.ActiveProjAndCustPage;
import com.actitime.pageObjects.CreateNewCustPage;
import com.actitime.pageObjects.EditCustomerInfoPage;
import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;
import com.actitime.pageObjects.OpenTasksPage;

public class TasksTest extends BaseLib{
	
	private static final String password = null;











	@Test
	public void createCustomer()
	{
		
		String username =  ExcelUtilities.readData("Sheet1", 1, 1);
		String password =  ExcelUtilities.readData("Sheet1", 2, 2);
		LoginPage lp =new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp = new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		ActiveProjAndCustPage app = new ActiveProjAndCustPage(driver);
		app.clickOnCreateNewCustBtn();
		String customerName = ExcelUtilities.readData("Sheet1", 3,3 );
		CreateNewCustPage cncp =new CreateNewCustPage(driver);
		cncp.createcustomername(customerName);
		app.verifyCreateCustomer(customerName);
		app.clickOnLogout();
	}
	
	
	
	
	
	
	@Test(dependsOnMethods= {"createCustomer"})
	public void deleteCustomer()
	{
		
		
		String username = ExcelUtilities.readData("Sheet1", 4, 1);
		String password = ExcelUtilities.readData("Sheet1", 4, 2);
		
		LoginPage lp =new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp = new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		String customerName = ExcelUtilities.readData("Sheet1", 4, 3);
		ActiveProjAndCustPage app =new ActiveProjAndCustPage(driver);
		
		app.selectedCustomer(customerName);
		
		EditCustomerInfoPage ecip =new EditCustomerInfoPage(driver);
		ecip.deleteCustomer();
		app.verifyDeleteCustomer();
		app.clickOnLogout();
	}
	
}
