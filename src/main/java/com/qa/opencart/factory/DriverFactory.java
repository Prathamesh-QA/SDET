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
	public static String highlight;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the webdriver on the basis of given browser name
	 * @param browserName
	 * @return
	 */
	public WebDriver initializeDriver(Properties environmentProperties) {
		
		String browserName = environmentProperties.getProperty("test.browser");
		System.out.println("Browser name is " + browserName);
		highlight = environmentProperties.getProperty("highlight").trim();
		optionsManager = new OptionsManager(environmentProperties);
		if(browserName.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(optionsManager.getCromeOptions());
			threadDriver.set(new ChromeDriver(optionsManager.getCromeOptions()));
		}else if(browserName.equalsIgnoreCase(Constants.FIREFOX_BROWSER)) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			threadDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}else if(browserName.equalsIgnoreCase(Constants.EDGE_BROWSER)) {
			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver(optionsManager.getEdgeOptions());
			threadDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		}else {
			throw new RuntimeException("Selected browser " + browserName + " is not valid");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
	}
	
	/**
	 * Return one copy of thread Selenium Webdriver 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return threadDriver.get();
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
