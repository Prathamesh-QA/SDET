/**
 * 
 */
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Base;
import com.qa.opencart.utils.XPathLocator;

/**
 * @author P.Dhamanaskar
 *
 */
public class LoginPage extends Base{
	
	private WebDriver driver;
	
	private final By username = getXpath("opencart.login.username", XPathLocator.BY_ID);
	private final By password = getXpath("opencart.login.password", XPathLocator.BY_ID);
	private final By login = getXpath("opencart.login.button", XPathLocator.BUTTON);
	
	
	public By getUsername() {
		return username;
	}
	public By getPassword() {
		return password;
	}
	public By getLogin() {
		return login;
	}
	
	

}
