package com.redbus.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
	private static final Logger log = Logger.getLogger(HomePage.class);

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

		log.info("Entering the city from : "+city); 

	}

	public void enterToCity(String city){
		toCity.sendKeys(city);
		log.info("Entering the city To : "+city);
	}


	public void setJourneyDate(String date){
		journeyCalender.click();
		log.info("Setting the journey date as : "+date);
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
		log.info("Setting the return date as : "+date);

	}


	public BusListPage clickOnSearchBuses(){
		searchBusButton.click();
		log.info("Clicking on Search Buses button");
		return new BusListPage(driver);
	}


	public boolean verifyHomePageTitle(String title){
		
	//	BaseTest.Logg1.info("Actual title of Home page is "+title);
		
		log.info("Actual title of Home page is "+title);
		log.info("Expected title of Home page is "+pageTitle);
		
		return pageTitle.equalsIgnoreCase(title) ;
	}

	public HotelsHomePage clickOnHotelLink(){
		log.info("Clicking on HOTELS link");
		hotels.click();
		return new HotelsHomePage(driver);
	}

	public CancelRefundPage clickOnCancelRefundLink(){
		log.info("Clicking on Easy Cancel/Refund link on Home page");
		cancelRefundLink.click();
		return new CancelRefundPage(driver);
	}

	public PrintSMSPage clickOnPrintSmsLink(){
		log.info("Clicking on Print/SMS Ticket link on Home page");
		printSmsLink.click();
		return new PrintSMSPage(driver);
	}

}
