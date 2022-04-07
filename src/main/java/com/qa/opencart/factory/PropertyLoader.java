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
public class PropertyLoader {
	
	WebDriver driver;
	
	/**
	 * This method is used to load/initialize the properties 
	 * @return Properties object loaded with environment config file
	 */
	public Properties initializeProperties(String relativeFileLocation) {
		
		Properties property = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + relativeFileLocation);
			property.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}

}
