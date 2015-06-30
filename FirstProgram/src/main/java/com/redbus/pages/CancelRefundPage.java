package com.redbus.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CancelRefundPage {

	
	private static final Logger log = Logger.getLogger(CancelRefundPage.class) ;
	WebDriver driver;
	public String errorMessageText = "Please enter valid ticket number";

	@FindBy(id="ctl00_ContentHolder_TBTicketNo")
	WebElement tripId;
	
	@FindBy(id="ctl00_ContentHolder_TBEMailId")
	WebElement emailId;
	
	@FindBy(id="ctl00_ContentHolder_btnSearch")
	WebElement searchButton;
	
	@FindBy(id="ctl00_ContentHolder_Message1")
	WebElement errorMessage;
	

	public CancelRefundPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void setTripId(String tid){
		log.info("Entering the Ticket number/Trip ID as : "+tid);
		tripId.sendKeys(tid);
	}
	
	public void setEmailId(String eid){
		log.info("Entering the Email ID as : "+eid);
		emailId.sendKeys(eid);
	}
	
	public void clickOnSearch(){
		log.info("Clicking on Search button");
		searchButton.click();
	}
	
	public String geEerrorMessage(){
		log.info("The error message shown is : "+errorMessage.getText());
		return errorMessage.getText();
	}
}
