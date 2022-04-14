/**
 * 
 */
package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

/**
 * @author P.Dhamanaskar
 *
 */
public class BaseTest {
	
	DriverFactory factory;
	public Properties environmentProp;
	public Properties messageProp;
	WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeTest(alwaysRun=true)
	public void setup() {
		factory = new DriverFactory();
		environmentProp = factory.initializeProperties(Constants.ENVIRONMENT_PROPERTIES);
		messageProp = factory.initializeProperties(Constants.MESSAGE_PROPERTIES);
		driver = factory.initializeDriver(environmentProp);
		driver.get(environmentProp.getProperty("test.url"));
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
