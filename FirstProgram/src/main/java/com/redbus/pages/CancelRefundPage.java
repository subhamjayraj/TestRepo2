package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelRefundPage {

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
		tripId.sendKeys(tid);
	}
	
	public void setEmailId(String eid){
		emailId.sendKeys(eid);
	}
	
	public void clickOnSearch(){
		searchButton.click();
	}
	
	public String geEerrorMessage(){
		return errorMessage.getText();
	}
}
