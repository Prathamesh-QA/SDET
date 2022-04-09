/**
 * 
 */
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.utils.Base;

/**
 * @author P.Dhamanaskar
 *
 */
public class LoginPage extends Base{
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private final By username = By.xpath("//input[@id='input-email']");
	private final By password = By.xpath("//input[@id='input-password']");
	private final By login = By.xpath("//input[@value='Login']");
	private final By forgotPasswordLink = By.cssSelector("div.form-group a");
	
	
	public WebElement getForgotPasswordLink() {
		return driver.findElement(forgotPasswordLink);
	}
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	//Page Actions
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkForgotLinkAvailability() {
		return getForgotPasswordLink().isEnabled();
	}
	
	public HomePage doLogin(String userName,String passWord) {
		System.out.println("User logged in with: " + userName + ":" + passWord);
		getUsername().sendKeys(userName);
		getPassword().sendKeys(passWord);
		getLogin().click();
		return new HomePage(driver);
	}

}
