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

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author P.Dhamanaskar
 *
 */
public class DriverFactory {
	
	WebDriver driver;
	
	/**
	 * This method is used to initialize the web-driver on the basis of the browser selected
	 * @param browserName
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("Browser name is: " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			new RuntimeException("Incorrect browser selected");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	/**
	 * This method is used to load/initialize the environment properties 
	 * @return Properties object loaded with environment config file
	 */
	public Properties initEnvironmentProperties() {
		
		Properties environmentProperties = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties");
			environmentProperties.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return environmentProperties;
	}
	/**
	 * This method is used to load/initialize the error message properties 
	 * @return Properties object loaded with message file
	 */
	public Properties initErrorMessageProperties() {
		
		Properties messageProperties = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\message-en.properties");
			messageProperties.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messageProperties;
	}
	/**
	 * This method is used to load/initialize the xpath properties 
	 * @return Properties object loaded with xpath Property file
	 */
	public Properties initXpathProperties() {
		
		Properties xpathProp = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\xpathprop.properties");
			xpathProp.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xpathProp;
	}

}
