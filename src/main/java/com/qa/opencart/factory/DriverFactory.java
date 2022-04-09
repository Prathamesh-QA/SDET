/**
 * 
 */
package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author P.Dhamanaskar
 *
 */
public class DriverFactory {
	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is used to initialize the webdriver on the basis of given browser name
	 * @param browserName
	 * @return
	 */
	public WebDriver initializeDriver(String browserName) {
		
		System.out.println("Browser name is " + browserName);
		if(browserName.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase(Constants.FIREFOX_BROWSER)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase(Constants.EDGE_BROWSER)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Selected browser " + browserName + " is not valid");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	/**
	 * This method is used to initialize the properties on the basis of given properties file location
	 * @param relativeFileLocation
	 * @return
	 */
	public Properties initializeProperties(String relativeFileLocation) {
		
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + relativeFileLocation);
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	

}
