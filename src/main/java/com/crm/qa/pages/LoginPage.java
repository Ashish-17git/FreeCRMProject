package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// page factory or OR object reprository
	//@Find by annotation
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginbutton;
	// initiaizing the page objects
	
	public LoginPage()throws IOException{
		PageFactory.initElements(driver, this); //initilize 
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public HomePage login(String un, String pas) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pas);
		loginbutton.click();
		return new HomePage();
	}
}
