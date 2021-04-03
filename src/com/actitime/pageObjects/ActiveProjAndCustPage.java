  package com.actitime.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

//import com.actitime.scripts.BasePage;
import com.actitime.pageObjects.BasePage;
public class ActiveProjAndCustPage extends BasePage{
	
	
	@FindBy(css="input[value*='Create New Customer']")
	private WebElement createNewCustomBtn;
	
	@FindBy(className ="successmsg")
	private WebElement successMsg;
	
	@FindBy(name="selectedCustomer")
	private WebElement customerDrpDwn;
	
	@FindBy(css="input[value*='Show']")
	private WebElement ShowBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href='customerId')]")
	private java.util.List<WebElement> customNameLink;
	
	
	public ActiveProjAndCustPage(WebDriver driver)
	{
		
		super(driver);
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void clickOnCreateNewCustBtn() {
		
		createNewCustomBtn.click();
	}
	
	
	public void verifyCreateCustomer(String customerName)
	{
		
		
		Assert.assertTrue(successMsg.isDisplayed());
		Reporter.log("Create customer msg is displayed", true);
		
		Assert.assertTrue(successMsg.getText().contains(customerName));
		Reporter.log(successMsg.getText(), true);
	}
	
	public void selectedCustomer(String customerName) {
		
		Select sel =new Select(customerDrpDwn);
		sel.selectByVisibleText(customerName);
		ShowBtn.click();
		if(customNameLink.get(0).getText().equals(customerName))
		{
			customNameLink.get(0).click();
		}
		else { 
			System.out.println(customerName+"customer does not exist");
		}
		
	}	
		
	public void verifyDeleteCustomer()
	{
		
		
		String expMsg ="Customer has been successfully deleted.";
		String actualMsg = successMsg.getText();
		Assert.assertEquals(actualMsg, expMsg);
		Reporter.log(expMsg, true);
		
	}
	
}
