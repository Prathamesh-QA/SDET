/**
 * 
 */
package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utils.Constants;
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
	
	private By productNameHeader = By.cssSelector("div.pb-center-column h1");
	private By productCondition = By.cssSelector("p#product_condition span");
	private By productDescription = By.cssSelector("div#short_description_content p");
	private By productPrice = By.cssSelector("span#our_price_display");
	private By productQuantity = By.cssSelector("input#input-quantity");
	private By addToCart = By.cssSelector("button#button-cart");
	private By productImages = By.xpath("//ul[@id='thumbs_list_frame']/li//img");
	
	//------------------------- Page Actions --------------------//
	
	public String getProductInfoPageTitle(String productName) {
		return elementUtils.waitForPageTitleContains(productName, Constants.PAGE_TITLE_TIMEOUT);
	}
	
	
	public Map<String,String> productInformation() {
		Map<String,String> productInfo = new HashMap<String,String>();
		productInfo.put("name", elementUtils.doGetText(productNameHeader));
		productInfo.put("condition", elementUtils.doGetText(productCondition));
		productInfo.put("description", elementUtils.doGetText(productDescription));
		productInfo.put("price", elementUtils.doGetText(productPrice));
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
	
}
