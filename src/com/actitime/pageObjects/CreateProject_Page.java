package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProject_Page {
	
	@FindBy(xpath="//a[@href='/tasks/otasklist.do']//div[@class='label']")
	private WebElement Task;
	@FindBy(linkText="Projects & Customers")
	private WebElement projAndCustLink;
	@FindBy(xpath="//input[@type='button' and @value='Create New Project']")
	private WebElement CreateNewPro;
	@FindBy(name="selectedCustomer")
	private WebElement customerDrpDwn;
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href='customerId')]")
	private java.util.List<WebElement> customNameLink;
	@FindBy(css="input[value*='Show']")
	private WebElement ShowBtn;
	@FindBy(xpath="//input[@type='text' and @name='name']")
	private WebElement ProjectNamevar;
	@FindBy(xpath="//textarea[@name='description' and @onkeyup='textLengthNote.update(this.value)']")
	private WebElement ProjectDes;
	@FindBy(xpath="//input[@type='submit' and @name='createProjectSubmit']")
	private WebElement CreateButton;
	
    
	public CreateProject_Page(WebDriver driver ) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnTask()
	{
		Task.click();
	}
	public void clickOnProjAndCustLink()
	{
		projAndCustLink.click();
	}
	public void CreateNewProjectMethod()
	{
		CreateNewPro.click();
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
 
public void ProjectName(String ProjectName, String ProjectDes1)
{
	ProjectNamevar.sendKeys("Medical Software");
	ProjectDes.sendKeys("This projet is related to medical software");
	
}

public void CreateProject()
{
	CreateButton.click();
}

}	



