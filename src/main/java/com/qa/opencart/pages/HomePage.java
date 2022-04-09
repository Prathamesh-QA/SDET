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

/**
 * @author P.Dhamanaskar
 *
 */
public class HomePage extends Base{
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private final By header = By.xpath("//div[@id='logo']//a");
	private final By sectionHeaders = By.cssSelector("div#content h2");
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public List<WebElement> getSectionHeaders() {
		return driver.findElements(sectionHeaders);
	}
	
	
	//page actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHeaderValue() {
		if(getHeader().isDisplayed()) {
			return getHeader().getText();
		}
		return null;
	}
	
	public Integer getHomePageSectionsCount() {
		return getSectionHeaders().size();
	}
	
	public List<String> getHomePageSectionsList() {
		List<String> sectionList = new ArrayList<String>();
		List<WebElement> homeSectionList = getSectionHeaders();
		for(WebElement element : homeSectionList) {
			System.out.println(element.getText());
			sectionList.add(element.getText());
		}
		return sectionList;
	}
	

}
