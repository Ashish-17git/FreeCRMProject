package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Ashish')]")
	@CacheLookup // this will get data from cached memory and increase speed
	WebElement userNamelabel;
	
	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactLink;
	
	@FindBy(xpath = "//button[contains(text(), 'New')]")
	WebElement newcontactLink;
	
	public HomePage()throws IOException{
		PageFactory.initElements(driver, this); 
}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNamelabel.isDisplayed();
	}
	public ContactsPage clickonContactsLink() throws IOException {
		contactLink.click();
	return new ContactsPage();
	}
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public void clickonNewContactLink() {
		contactLink.click();
		newcontactLink.click();
	}
	
	
	
}