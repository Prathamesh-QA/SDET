/**
 * 
 */
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Base;
import com.qa.opencart.utils.XPathLocator;

/**
 * @author P.Dhamanaskar
 *
 */
public class LoginPage extends Base{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private final By username = getXpath("opencart.login.username", XPathLocator.BY_ID);
	private final By password = getXpath("opencart.login.password", XPathLocator.BY_ID);
	private final By login = getXpath("opencart.login.button", XPathLocator.BUTTON);
	private final By forgotPasswordLink = By.cssSelector("div.form-group a");
	
	
	public WebElement getForgotPasswordLink() {
		return getElement(forgotPasswordLink);
	}
	public WebElement getUsername() {
		return getElement(username);
	}
	public WebElement getPassword() {
		return getElement(password);
	}
	public WebElement getLogin() {
		return getElement(login);
	}
	
	//Page Actions
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkForgotLinkAvailability() {
		return getForgotPasswordLink().isEnabled();
	}
	
	

}
