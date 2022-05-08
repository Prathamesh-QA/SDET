/**
 * 
 */
package com.qa.opencart.utils;

/**
 * @author P.Dhamanaskar
 *
 */
public class Constants {
	
	
	// File Path
	public static String ENVIRONMENT_PROPERTIES = "\\src\\test\\resources\\configuration\\config.properties";
	public static String MESSAGE_PROPERTIES = "\\src\\test\\resources\\configuration\\message-en.properties";
	public static String XPATH_PROPERTIES = "\\src\\test\\resources\\configuration\\xpathprop.properties";
	
	//Browsername
	public static String CHROME_BROWSER = "chrome";
	public static String FIREFOX_BROWSER = "firefox";
	public static String EDGE_BROWSER = "edge";
	
	//Timeouts
	public static int PAGE_TITLE_TIMEOUT = 5;
	public static int EXPLICIT_WAIT_TIMEOUT = 10;
	public static int EXPLICIT_WAIT_POLLING_TIME = 2;
	
	//TITLE
	public static String LOGIN_PAGE_TITLE = "Login - My Store";
	public static String HOME_PAGE_TITLE = "My Store";
	public static String PRODUCT_PAGE_BLOUSE_TITLE = "Blouse - My Store";
	public static String PRODUCT_PAGE_FADDEDSHORTSLEEVE_TITLE = "Faded Short Sleeve T-shirts - My Store";
	
	//ASSERTION
	public static String PRODUCT_BLOUSE_CONDITION = "New";
	public static String PRODUCT_BLOUSE_DESCRIPTION = "Short sleeved blouse with feminine draped sleeve detail.";
	public static String PRODUCT_BLOUSE_PRICE = "$27.00";
	
	
	

}
