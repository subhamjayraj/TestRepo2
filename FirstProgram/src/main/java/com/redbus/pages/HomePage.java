package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	String pageTitle = "redBus : Online Bus Ticket Booking, Book Volvo AC Bus Tickets, Reservation";

	@FindBy(id="ctl00_hotelDiv")
	WebElement hotels ;
	
	@FindBy(id="txtSource")
	WebElement fromCity ;

	@FindBy(id="txtDestination")
	WebElement toCity ;

	@FindBy(id="txtOnwardCalendar")
	WebElement journeyCalender ;

	@FindBy(id="txtReturnCalendar")
	WebElement returnCalender ;

	@FindBy(id="searchBtn")
	WebElement searchBusButton ;

	@FindBy(id="rbcal_txtOnwardCalendar")
	WebElement onWardDateWidget ;

	@FindBy(id=" ")
	WebElement returnDateWidget ;

	@FindBy(linkText="Easy Cancel/Refund")
	WebElement cancelRefundLink ;
	
	@FindBy(linkText="Print/SMS Ticket")
	WebElement printSmsLink ;
	
	

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFromCity(String city){
		fromCity.sendKeys(city);
	}

	public void enterToCity(String city){
		toCity.sendKeys(city);
	}


	public void setJourneyDate(String date){
		journeyCalender.click();

		List<WebElement> columns=onWardDateWidget.findElements(By.tagName("td")); 
		for (WebElement cell: columns){  		  
			if (cell.getText().equals(date)){  
				cell.click();				
				break;  
			}  
		}  
	}

	public void setReturnDate(String date){
		returnCalender.click();

	}


	public BusListPage clickOnSearchBuses(){
		searchBusButton.click();
		return new BusListPage(driver);
	}


	public boolean verifyHomePageTitle(String title){
		return pageTitle.equalsIgnoreCase(title) ;
	}

	public HotelsHomePage clickOnHotelLink(){
		hotels.click();
		return new HotelsHomePage(driver);
	}

	public CancelRefundPage clickOnCancelRefundLink(){
		cancelRefundLink.click();
		return new CancelRefundPage(driver);
	}
	
	public PrintSMSPage clickOnPrintSmsLink(){
		printSmsLink.click();
		return new PrintSMSPage(driver);
	}

}
