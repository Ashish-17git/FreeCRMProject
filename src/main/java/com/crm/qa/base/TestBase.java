package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException { //public constructor
		 prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialization() throws IOException {
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Automation\\chromeVer\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Desktop\\Automation\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		e_driver =new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver; 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //PAGE_LOAD_TIMEOUT fetching value from TestUtil class
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); //IMPLICIT_WAIT fetching value from TestUtil class
		
		driver.get(prop.getProperty("url"));
	}
}
