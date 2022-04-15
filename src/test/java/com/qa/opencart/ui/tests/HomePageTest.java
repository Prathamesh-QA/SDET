/**
 * 
 */
package com.qa.opencart.ui.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

/**
 * @author P.Dhamanaskar
 *
 */
public class HomePageTest extends BaseTest{
	
	@BeforeClass(alwaysRun = true)
	public void homePageSetup() {
		homePage = loginPage.doLogin(environmentProp.getProperty("test.username"), environmentProp.getProperty("test.password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE); 
	}
	
	@Test(priority=2)
	public void verifyHomePageLogoTest() {
		Assert.assertEquals(homePage.getHeaderValue(), messageProp.getProperty("home.header"));
	}
	
	@Test(priority=3)
	public void verifyHomePageSectionCountTest() {
		Assert.assertTrue(homePage.getHomePageSectionsCount() == Integer.parseInt(messageProp.getProperty("home.section.count")));
	}

	@Test(priority=4)
	public void verifyHomePageSectionListTest() {
		List<String> sectionList = homePage.getHomePageSectionsList();
		System.out.println(sectionList);
	}
	
	@Test(priority=5)
	public void searchIMacTest() {
		Assert.assertTrue(homePage.doSearch("iMac"));
	}
	
	@Test(priority=5)
	public void searchMacbookTest() {
		Assert.assertTrue(homePage.doSearch("MacBook Air"));
	}
	
	@Test(priority=6)
	public void verifyProductResultsTest() {
		homePage.doSearch("iMac");
		homePage.selectSearchedProduct("iMac");
	}

}
