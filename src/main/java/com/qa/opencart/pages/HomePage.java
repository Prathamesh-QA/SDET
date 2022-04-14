/**
 * 
 */
package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Base;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

/**
 * @author P.Dhamanaskar
 *
 */
public class HomePage extends Base{
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	private final By header = By.xpath("//div[@id='logo']//a");
	private final By sectionHeaders = By.cssSelector("div#content h2");
	private final By searchBox = By.xpath("//div[@id='search']/input[@name='search']");
	private final By searchButton = By.xpath("//div[@id='search']//button[@type='button']");
	
	
	//page actions
	public String getHomePageTitle() {
		return elementUtils.waitForPageTitleToBe(Constants.HOME_PAGE_TITLE, Constants.PAGE_TITLE_TIMEOUT);
	}
	
	public String getHeaderValue() {
		if(elementUtils.doIsDisplayed(header)) {
			return elementUtils.doGetText(header);
		}
		return null;
	}
	
	public Integer getHomePageSectionsCount() {
		return elementUtils.getElements(sectionHeaders).size();
	}
	
	public List<String> getHomePageSectionsList() {
		List<String> sectionList = new ArrayList<String>();
		List<WebElement> homeSectionList = elementUtils.getElements(sectionHeaders);
		for(WebElement element : homeSectionList) {
			System.out.println(element.getText());
			sectionList.add(element.getText());
		}
		return sectionList;
	}
	

}
