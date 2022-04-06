/**
 * 
 */
package com.qa.opencart.utils;

import java.io.File;
import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.PropertyLoader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author P.Dhamanaskar
 *
 */
public class Base {
	
	public static WebDriver driver;
	PropertyLoader factory;
	Properties environmentProp;
	Properties messageProp;
	Properties xpathProp;
	public File folder;
	
	public Base() {
		environmentProp = factory.initializeProperties(Constants.ENVIRONMENT_PROPERTIES);
		messageProp = factory.initializeProperties(Constants.MESSAGE_PROPERTIES);
		xpathProp = factory.initializeProperties(Constants.XPATH_PROPERTIES);
	}
	
	/**
	 * This method is used to initialize the web-driver on the basis of the browser selected
	 * @param browserName
	 */
	public WebDriver initializeDriver() {
		Map<String,Object> chromePrefs;
		String browserName = environmentProp.getProperty("test.browser");
		System.out.println("Browser name is: " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			chromePrefs = new HashMap<String,Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", folder.getAbsolutePath());
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(chromeOptions);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			new RuntimeException("Incorrect browser selected");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(environmentProp.getProperty("test.url").trim());
		
		return driver;
	}
	
	
	/**
	 * 
	 * @param locator find the locator to be used for further actions
	 * @return
	 */
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/************************ Dropdown Utils *********************************/
	public void doSelectDropdownVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectDropdownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectDropdownValue(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	/*********************** Actions Utils ***********************************/
	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	public void doActionsSendKeys(By locator, String text) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), text).perform();
	}

	/************************** WebDriver Wait *******************************/

	public String waitForPageTitle(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public String waitForPageTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}

	public String waitForPageUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlToBe(url));
		return driver.getTitle();
	}

	public String waitForPageUrlContains(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getTitle();
	}

	public Alert waitForAlertPresence(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	/**
	 * An Exception of Element is present on the DOM of the page that means the
	 * element is not necessarily present
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An Exception of Element is present on the DOM of the page that means the
	 * element is not necessarily present with Polling time specified
	 * 
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return
	 */
	public WebElement waitForElementPresent(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, pollingTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Wait for element to be visible and enabled such that you can click on it
	 * 
	 * @param locator
	 * @param timeout
	 */
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	/**
	 * Wait for element to be visible and enabled such that you can click on it by
	 * performing some actions
	 * 
	 * @param locator
	 * @param timeout
	 */
	public void doActionsClickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	/**
	 * A expectation of checking that all the relative locator present on the web
	 * page that match the locator are visible Visibility means not only the
	 * elements are visible are but the height and width are greater than 0
	 * 
	 * @param locator
	 * @param timeOut
	 * @return list of WebElements which are located with match on webpage
	 */
	public List<WebElement> visibilityOfAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * A expectation of checking that all the relative locator present on the web
	 * page that match the locator are visible then return the list of all the text
	 * of the elements
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<String> getPageElementsText(By locator, int timeOut) {
		List<String> list = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).stream()
				.forEach(element -> list.add(element.getText()));
		return list;
	}

	/**
	 * This is a Fluent Wait where we can customize the Polling time i.e sleep
	 * between the intervals
	 * 
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return
	 */
	public WebElement waitWithFluentWait(By locator, int timeout, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(pollingTime, TimeUnit.SECONDS) // polling time i.e interval in which wait mechanism is// called
				.ignoring(NoSuchElementException.class) // ignoring specific exception occuring during polling
				.ignoring(StaleElementReferenceException.class); // ignoring specific exception occuring during polling
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This element is trying to get the WebElement dynamic wait to find the
	 * webelement
	 * 
	 * @param locator
	 * @param timeOut
	 * @return element
	 */
	public WebElement retryingElement(By locator) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < 30) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				e.getMessage();
			} catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				e.getMessage();
			}
			attempts++;
		}
		return element;
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
