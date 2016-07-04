package com.tomtom.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.base.BaseTest;
import com.redbus.pages.HomePage;
import com.redbus.pages.LoginFramePage;
import com.redbus.pages.WaitHelper;

public class SignInOutTest extends BaseTest{
	
	
	@Test
	public void signInOutTest() throws InterruptedException{
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyHomePageTitle(driver.getTitle()));	
		
		LoginFramePage loginFramePage = homePage.clickOnSignUpInSwitchToLoginframe();
		
		loginFramePage.clickOnSignIn();
		loginFramePage.setEmailMobile("subhamjay96@mindtree.com");
		loginFramePage.setPassword("123456");
		HomePage homePage1= loginFramePage.clickOnSignInButton();
		homePage1 = homePage1.clickOnCloseLoginFrame();
		
		WaitHelper.ThreadWait(5);		
		
		Assert.assertTrue(homePage1.myAccountText.equalsIgnoreCase(homePage1.getMyAccountText()) );
		
		WaitHelper.ThreadWait(5);
		
		HomePage homePage2 = homePage1.clickOnSignOutLink();

		Assert.assertTrue(homePage2.signUpInText.equalsIgnoreCase(homePage2.getsignUpInText()) );
		
		
		
	}

}
