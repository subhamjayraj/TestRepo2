package com.tomtom.practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.base.BaseTest;
import com.redbus.pages.CancelRefundPage;
import com.redbus.pages.HomePage;
import com.redbus.pages.WaitHelper;

public class CancelRefundErrorMessageTest extends BaseTest{	
	
	
	@Test
	public void testErrorMessage(){
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyHomePageTitle(driver.getTitle()));	
		
		CancelRefundPage cancelrefundPage = homePage.clickOnCancelRefundLink();
		
		WaitHelper.ThreadWait(2);
		
		cancelrefundPage.setTripId("123456");
		cancelrefundPage.setEmailId("Subham.Kumar@mindtree.com");
		cancelrefundPage.clickOnSearch();
		
		WaitHelper.ThreadWait(3);		
		
		Assert.assertEquals(cancelrefundPage.geEerrorMessage(), cancelrefundPage.errorMessageText);
							
	}
}
