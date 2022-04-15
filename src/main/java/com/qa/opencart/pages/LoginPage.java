/**
 * 
 */
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

/**
 * @author P.Dhamanaskar
 *
 */
public class LoginPage{
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	//Locators
	private final By username = By.xpath("//input[@id='input-email']");
	private final By password = By.xpath("//input[@id='input-password']");
	private final By login = By.xpath("//input[@value='Login']");
	private final By forgotPasswordLink = By.cssSelector("div.form-group a");
	
	//Page Actions
	public String getPageTitle() {
		return elementUtils.waitForPageTitleToBe(Constants.LOGIN_PAGE_TITLE, Constants.PAGE_TITLE_TIMEOUT);
	}
	
	public boolean checkForgotLinkAvailability() {
		return elementUtils.doIsDisplayed(forgotPasswordLink);
	}
	
	public HomePage doLogin(String userName,String passWord) {
		System.out.println("User logged in with: " + userName + ":" + passWord);
		elementUtils.doSendKeys(username, userName);
		elementUtils.doSendKeys(password, passWord);
		elementUtils.doClick(login);
		return new HomePage(driver);
	}

}
