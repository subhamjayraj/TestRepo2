package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsHomePage {

	WebDriver driver;
	String pageTitle = "Online Hotel Booking, Hotels in India, Luxury, Star, Budget Hotels -redBus.in";

	@FindBy(id="txtSource")
	WebElement destintion;

	@FindBy(id="txtOnwardCalendar")
	WebElement checkIn;	

	@FindBy(id="txtReturnCalendar")
	WebElement checkOut;

	@FindBy(id="rbcal_txtOnwardCalendar")
	WebElement checkInDateWidget;	

	@FindBy(id="rbcal_txtReturnCalendar")
	WebElement checkOutDateWidget;

	@FindBy(id="searchBtn")
	WebElement searchHotelsButton;

	public HotelsHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setDestination(String dest){
		destintion.sendKeys(dest);
	}
	
	public void setCheckIndate(String date){
		checkIn.click();
		List<WebElement> columns=checkInDateWidget.findElements(By.tagName("td")); 
		for (WebElement cell: columns){  		  
			if (cell.getText().equals(date)){  
				cell.click();				
				break;  
			}  
		}		
	}

	public void setCheckOutdate(String date){
		checkOut.click();
		List<WebElement> columns=checkOutDateWidget.findElements(By.tagName("td")); 
		for (WebElement cell: columns){  		  
			if (cell.getText().equals(date)){  
				cell.click();				
				break;  
			}  
		}		
	}

	public HotelsListPage clickOnSearchHotelsButton(){
		searchHotelsButton.click();
	//	WaitHelper.ThreadWait(5);
		return  new HotelsListPage(driver);
	}
	
	public String getHotelsHomePageTitle(){
		return pageTitle;
	}

}



