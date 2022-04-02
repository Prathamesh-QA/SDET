/**
 * 
 */
package com.qa.opencart.utils;

import java.util.Properties;
import org.openqa.selenium.By;
import com.qa.opencart.factory.DriverFactory;

/**
 * @author P.Dhamanaskar
 *
 */
public class Base {
	
	DriverFactory factory;
	Properties environmentProperties;
	Properties messageProperties;
	Properties xpathProp;
	
	public Base() {
		
		environmentProperties = factory.initEnvironmentProperties();
		messageProperties = factory.initErrorMessageProperties();
		xpathProp = factory.initXpathProperties();
	}
	
	public String resolveProperty(final String key, final String... values) {
		String prop = xpathProp.getProperty(key);
		if (prop == null) {
			throw new RuntimeException("Couldn't find property with key: " + key);
		}
		for (int i = 0; i < values.length; i++) {
			prop = prop.replace("{" + i + "}", values[i]);
		}
		return prop;
	}
	public String resolve(final String key) {
		return resolveProperty(key);
	}
	
	public By getXpath(String labelProperty, XPathLocator xpath) {
		String Xpath = xpath.get(resolve(labelProperty));
		return By.xpath(Xpath);
	}

}
