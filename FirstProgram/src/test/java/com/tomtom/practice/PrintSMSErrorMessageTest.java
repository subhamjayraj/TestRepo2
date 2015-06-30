package com.tomtom.practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.base.BaseTest;
import com.redbus.pages.HomePage;
import com.redbus.pages.PrintSMSPage;

public class PrintSMSErrorMessageTest extends BaseTest{

	@Test
	public void testPrintSmsErrorMessage(){

		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyHomePageTitle(driver.getTitle()));	

		PrintSMSPage printSmsPage = homePage.clickOnPrintSmsLink();

		printSmsPage.setTicketNumber("1234567");
		printSmsPage.clickPrintTicket();
		printSmsPage.clickSubmitButton();

		Assert.assertEquals(printSmsPage.wrongTicktNoMessageShown(), printSmsPage.wrongTicktNoMessageShown());

	}
}

















