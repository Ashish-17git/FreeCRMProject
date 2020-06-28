package com.crm.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	public HomePageTest() throws IOException {
		super();	
	}
	//test case should be separated, -- independent of each other
	//before each test case -- launch the browser and login 
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		contactPage =  new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "Cogmento CRM", "home page title not matched");
	}
	@Test(priority=2)
	public void verifyCorrectUsernameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyContactListTest() throws IOException {
		contactPage = homePage.clickonContactsLink();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
