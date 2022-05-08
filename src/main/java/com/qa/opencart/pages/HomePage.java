/**
 * 
 */
package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

/**
 * @author P.Dhamanaskar
 *
 */
public class HomePage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	private final By logo = By.cssSelector("div#header_logo a");
	private final By sectionHeaders = By.xpath("//ul[contains(@class,'sf-menu')]/li/a");
	private final By searchBox = By.cssSelector("input#search_query_top");
	private final By searchButton = By.xpath("//form[@id='searchbox']/button[@name='submit_search']");
	private final By searchItemResults = By.xpath("//ul[contains(@class,'product_list')]/li");
	private final By resultItemsLink = By.xpath("//div[@class='product-container']//a[@class='product-name']");
	
	
	//page actions
	public String getHomePageTitle() {
		return elementUtils.waitForPageTitleToBe(Constants.HOME_PAGE_TITLE, Constants.PAGE_TITLE_TIMEOUT);
	}
	
	public boolean isHomePageLogoIsPresent() {
		return elementUtils.doIsDisplayed(logo);
	}
	
	public Integer getHomePageSectionsCount() {
		return elementUtils.getElements(sectionHeaders).size();
	}
	
	public List<String> getHomePageSectionsList() {
		List<String> sectionList = new ArrayList<String>();
		List<WebElement> homeSectionList = elementUtils.getElements(sectionHeaders);
		for(WebElement element : homeSectionList) {
			sectionList.add(element.getText());
		}
		return sectionList;
	}
	
	public boolean doSearch(String productName) {
		elementUtils.doSendKeys(searchBox, productName);
		elementUtils.doClick(searchButton);
		return (elementUtils.getElements(searchItemResults).size() > 0);
	}
	
	public ProductInfoPage selectSearchedProduct(String productName) {
		List<WebElement> resultItemsList = elementUtils.getElements(resultItemsLink);
		System.out.println("Total Number of Items displayed " + resultItemsList.size());
		resultItemsList.stream()
			.filter(results -> results.getText().equals(productName))
			.forEach(result -> result.click());
		return new ProductInfoPage(driver);
	}
	

}
