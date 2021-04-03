package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerInfoPage {
	
@FindBy(css="input[value='Delete This Customer']")
private WebElement deleteThisCustBtn;


@FindBy(id="deleteButton")
private WebElement deleteBtn;



public EditCustomerInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}

public void deleteCustomer()
{
	deleteThisCustBtn.click();
	deleteBtn.click();
}

	
}
