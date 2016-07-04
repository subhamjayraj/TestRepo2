package com.tomtom.practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.base.BaseTest;
import com.redbus.pages.HomePage;
import com.redbus.pages.HotelsHomePage;
import com.redbus.pages.HotelsListPage;
import com.redbus.pages.WaitHelper;

public class CheckCheapestHotelDetailsTest extends BaseTest{

		
	@Test
	public void testCheapestHotel(){
		
		HomePage homePage = new HomePage(driver);
		WaitHelper.ThreadWait(3);
		Assert.assertTrue(homePage.verifyHomePageTitle(driver.getTitle()));	
		
		HotelsHomePage hotelshmpage = homePage.clickOnHotelLink();
		
		WaitHelper.ThreadWait(5);
		
		Assert.assertEquals(driver.getTitle(), hotelshmpage.getHotelsHomePageTitle());
		
		hotelshmpage.setDestination("Bangalore");
	//	hotelshmpage.setCheckIndate("23");
	//	hotelshmpage.setCheckOutdate("25");
		
		HotelsListPage hotelslistPage=hotelshmpage.clickOnSearchHotelsButton();
		WaitHelper.ThreadWait(5);
		
		Assert.assertTrue(hotelslistPage.verfyHeadingInputPresent());
		WaitHelper.ThreadWait(5);
		Assert.assertNotEquals(10000, hotelslistPage.HotelDetailsHavingMinimumPrice() );
		
	}	
	
}

