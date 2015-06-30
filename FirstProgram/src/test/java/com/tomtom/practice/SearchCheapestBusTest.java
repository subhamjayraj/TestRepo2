package com.tomtom.practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.base.BaseTest;
import com.redbus.pages.BusListPage;
import com.redbus.pages.HomePage;
import com.redbus.pages.WaitHelper;


public class SearchCheapestBusTest extends BaseTest{	
			
	@Test
	public void testCheapestBus(){
	
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyHomePageTitle(driver.getTitle()));		
	
		homePage.enterFromCity("Bangalore");
		homePage.enterToCity("Pune");
		homePage.setJourneyDate("30");		
		
		BusListPage busList=homePage.clickOnSearchBuses();				
				
		WaitHelper.ThreadWait(5);
		Assert.assertTrue(busList.verifyBusListPageTitle(driver.getTitle()));		
		
		Assert.assertTrue(busList.verfyModifyLinkPresent());
		
		Assert.assertNotEquals(10000, busList.BusDetailsHavingMinimumPrice());
	}

}














































