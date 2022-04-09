/**
 * 
 */
package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

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
		Assert.assertEquals(homePage.getHomePageTitle(), messageProp.getProperty("home.title")); 
	}
	
	@Test(priority=2)
	public void verifyHomePageLogoTest() {
		Assert.assertEquals(homePage.getHeaderValue(), messageProp.getProperty("home.header"));
	}
	
	@Test(priority=3)
	public void verifyHomePageSectionCountTest() {
		Assert.assertTrue(homePage.getHomePageSectionsCount() == 4);
	}

	@Test(priority=4)
	public void verifyHomePageSectionListTest() {
		List<String> sectionList = homePage.getHomePageSectionsList();
		System.out.println(sectionList);
	}

}
