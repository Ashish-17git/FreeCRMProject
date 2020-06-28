package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	String sheetName="contacts";
	
	public ContactsPageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		contactPage =  new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickonContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageList() {
		Assert.assertTrue(contactPage.verifyContactsLabel(), "contact label is missing on the table");
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String socialAccount) {
		homePage.clickonNewContactLink();
		//contactPage.createNewContact("facebook", "TestAuto1", "testLast1");
		contactPage.createNewContact(socialAccount, firstName, lastName);
	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
