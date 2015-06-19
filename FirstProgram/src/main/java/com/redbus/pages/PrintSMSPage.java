package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintSMSPage {

	
	WebDriver driver;
	private String pageTitle="Print Ticket/SMS | redBus™";
	private String invalidMessage = "Please enter Ticket Number";
	
	private String wrongTicktNoMessage = "You have either typed a wrong ticket no# or the ticket is invalid."+"/n"
	                                    +"Please get in touch with our customer support team at LIVE HELP.";
	
	@FindBy(id="ctl00_ContentHolder_TBTIN")
	WebElement ticketNumber;
	
	@FindBy(id="ctl00_ContentHolder_rBTicketOptions_0")
	WebElement printTicket;
	
	@FindBy(id="ctl00_ContentHolder_rBTicketOptions_1")
	WebElement ticketBySms;
	
	@FindBy(id="ctl00_ContentHolder_rBTicketOptions_2")
	WebElement ticketByMail;
	
	@FindBy(id="ctl00_ContentHolder_BtnSubmit")
	WebElement submitButton;
	
	@FindBy(id="ctl00_ContentHolder_RFVTicket")
	WebElement invalidMsg ;
	
	@FindBy(id="ctl00_ContentHolder_Message1_LBMessage")
	WebElement wrongTicketMsg ;
	
	
	public PrintSMSPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle(){
		return pageTitle;
	}
	
	public String getInvalidMessage() {
		return invalidMessage;
	}

	public String getWrongTicktNoMessage() {
		return wrongTicktNoMessage;
	}
	
	public void setTicketNumber(String ticketNo){
		ticketNumber.clear();
		ticketNumber.sendKeys(ticketNo);
	}
	
	public void clickPrintTicket(){
		printTicket.click();
	}
	
		
	public void clickTicketbySms(){
		ticketBySms.click();
	}
	
	public void clickTicketbyEmail(){
		ticketByMail.click();
	}
	
	public void clickSubmitButton(){
		submitButton.click();
	}
	
	
	public String invlidMessageShown(){	 
		return invalidMsg.getText();
	}
	
	public String wrongTicktNoMessageShown(){
		return wrongTicketMsg.getText();
	}
	
	
}















