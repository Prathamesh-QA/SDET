/**
 * 
 */
package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

/**
 * @author P.Dhamanaskar
 *
 */
public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), messageProp.getProperty("login.title"));
	}
	
	@Test(priority=2)
	public void forgotPasswordPresenceTest() {
		Assert.assertTrue(loginPage.checkForgotLinkAvailability());
	}
	
	@Test(priority=3)
	public void validLoginTest() {
		loginPage.doLogin(environmentProp.getProperty("test.username"), environmentProp.getProperty("test.password"));
	}

}
