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
	
	private By header = By.cssSelector("h1.page-heading");
	private By mrSelection = By.cssSelector("input#id_gender1");
	private By mrsSelection = By.cssSelector("input#id_gender2");
	private By firstname = By.xpath("//input[@id='customer_firstname']");
	private By lastname = By.xpath("//input[@id='customer_lastname']");
	private By email = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='passwd']");
	private By date = By.cssSelector("select#days");
	private By month = By.cssSelector("select#months");
	private By year = By.cssSelector("select#years");
	private By company = By.cssSelector("input#company");
	private By addressLine1 = By.cssSelector("input#address1");
	private By addressLine2 = By.cssSelector("input#address2");
	private By postalCode = By.cssSelector("input#postcode");
	private By city = By.cssSelector("input#city");
	private By state = By.cssSelector("select#id_state");
	private By country = By.cssSelector("select#select#id_country");
	private By mobile = By.xpath("//input[@id='phone_mobile']");
	private By submitButton = By.xpath("//button[@id='submitAccount']");
	private By successMessage = By.cssSelector("p.info-account");
	private By errorMessage = By.cssSelector("div#create_account_error li");
	
	//page actions
	/**
	 * This method will register the desired user on the application
	 * @param registrationData
	 */
	public void accountRegistration(String... registrationData) {
		
	}
	
	
	

}
