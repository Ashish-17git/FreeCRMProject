package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	@Test(priority=2)
	public void loginTest() throws IOException {
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
