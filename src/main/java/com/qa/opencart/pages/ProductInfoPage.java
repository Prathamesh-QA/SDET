/**
 * 
 */
package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

/**
 * @author P.Dhamanaskar
 *
 */
public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	private By productNameHeader = By.cssSelector("div#product-product h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By productQuantity = By.cssSelector("input#input-quantity");
	private By addToCart = By.cssSelector("button#button-cart");
	private By productImages = By.xpath("//a[@class='thumbnail']/img");
	
	public Map<String,String> productInformation() {
		Map<String,String> productInfo = new HashMap<String,String>();
		productInfo.put("name", elementUtils.doGetText(productNameHeader));
		List<WebElement> productMetadataList = elementUtils.getElements(productMetaData);
		productMetadataList.stream()
			.forEach(e -> productInfo.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim()));
		List<WebElement> productPriceList = elementUtils.getElements(productPrice);
		productInfo.put("price", productPriceList.get(0).getText().trim());
		productInfo.put(productPriceList.get(1).getText().split(":")[0].trim(), productPriceList.get(1).getText().split(":")[1].trim());
		return productInfo;
	}
	
	public void selectQuantity(String quantity) {
		elementUtils.doSendKeys(productQuantity, quantity);
	}
	
	public void addToCart() {
		elementUtils.doClick(addToCart);
	}
	
	public int getProductImages() {
		return elementUtils.getElements(productImages).size();
	}
	
	public void getProductInfoPageTitle(String productName) {
		elementUtils.waitForPageTitleToBe(productName, 5);
	}

}
