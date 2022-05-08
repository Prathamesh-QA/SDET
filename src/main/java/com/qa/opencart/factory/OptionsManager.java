/**
 * 
 */
package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author P.Dhamanaskar
 *
 */
public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions chrome;
	private FirefoxOptions firefox;
	private EdgeOptions edge;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getCromeOptions() {
		chrome = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) chrome.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) chrome.addArguments("--incognito");
		return chrome;	
	}
	
	public FirefoxOptions getFirefoxOptions() {
		firefox = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) firefox.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) firefox.addArguments("--incognito");
		return firefox;
	}
	
	public EdgeOptions getEdgeOptions() {
		edge = new EdgeOptions();
//		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) firefox.addArguments("--headless");
//		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) firefox.addArguments("--incognito");
		return edge;
	}

}
