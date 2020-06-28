package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//initialize the page object
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath ="//span[text()='Contacts']")  //page factory
	WebElement contactsLable;
	
	@FindBy(name ="first_name")
	WebElement firstName;
	
	@FindBy(name ="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	public boolean verifyContactsLabel() {
		return contactsLable.isDisplayed();
	}
	
	public void selectContacts() {
		driver.findElement(By.xpath("//td[contains(text(),'Active')]//parent::tr//input[@name='id']")).click();
	}
	
	public void createNewContact(String social, String fname, String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		
		Select select = new Select(driver.findElement(By.name("channel_type")));
		select.selectByValue(social);
		saveButton.click();
	}
	
}
