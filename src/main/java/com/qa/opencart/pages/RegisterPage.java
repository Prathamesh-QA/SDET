/**
 * 
 */
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

/**
 * @author P.Dhamanaskar
 *
 */
public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	private By header = By.cssSelector("div#content h1");
	private By firstname = By.xpath("//input[@id='input-firstname']");
	private By lastname = By.xpath("//input[@id='input-lastname']");
	private By email = By.xpath("//input[@id='input-email']");
	private By telephone = By.xpath("//input[@id='input-telephone']");
	private By password = By.xpath("//input[@id='input-password']");
	private By confirmPassword = By.xpath("//input[@id='input-confirm']");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']/input[@type='radio' and @value='0']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']/input[@type='radio' and @value='1']");
	private By agreement = By.cssSelector("input[name='agree']");
	private By submitButton = By.xpath("//input[@type='submit']");
	
	
	
	
	

}
