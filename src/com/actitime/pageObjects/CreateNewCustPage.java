package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustPage {
	
	
	@FindBy(name="name")
	private WebElement custNameTxBx;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomBtn;
	
	public CreateNewCustPage(WebDriver driver ) {
		
		
		PageFactory.initElements(driver, this);
		
	}

	
	public void createcustomername(String customerName){
		
		custNameTxBx.sendKeys(customerName);
		createCustomBtn.click();
	}
}
