package com.redbus.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelsHomePage {
	
	private static final Logger log = Logger.getLogger(HotelsHomePage.class);

	WebDriver driver;
	String pageTitle = "Online Hotel Booking: Cheap, Budget & Luxury Star Hotels India – redBus.in";	                    

	@FindBy(id="search_key")
	WebElement destintion;

	@FindBy(id="txtOnwardCalendar")
	WebElement checkIn;	

	@FindBy(id="txtReturnCalendar")
	WebElement checkOut;

	@FindBy(id="rbcal_txtOnwardCalendar")
	WebElement checkInDateWidget;	

	@FindBy(id="rbcal_txtReturnCalendar")
	WebElement checkOutDateWidget;

	@FindBy(id="search_hotel") 
	WebElement searchHotelsButton;

	public HotelsHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setDestination(String dest){
		log.info("Enterring City/Destination as : "+dest);
		
 		destintion.click();
		destintion.sendKeys(dest);
		WaitHelper.ThreadWait(5);
		List<WebElement> ele =driver.findElement(By.className("suggestions-box")).findElements(By.className("suggestion-row")) ;
		List<WebElement> ele1 =driver.findElement(By.className("suggestions-box")).findElements(By.className("suggestion-row")) ;
		System.out.println("-----total suggestion :"+ele.size());
		for(WebElement option : ele){
		WebElement sugg = option.findElement(By.cssSelector("div.name.suggestion-item-cl.gtm-location")) ;	
		System.out.println("-----"+sugg.getText());
	        if(sugg.getText().contains(dest) ) {
	        	System.out.println("Trying to select: "+dest);
	            sugg.click();
	            break;
	        }
		}
	}
	
	public void setCheckIndate(String date){
		log.info("Entering Check In date as : "+date);
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
		log.info("Entering Check Out date as : "+date);
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
		log.info("Clicking on Search Hotels button");
		searchHotelsButton.click();
	//	WaitHelper.ThreadWait(5);
		return  new HotelsListPage(driver);
	}
	
	public String getHotelsHomePageTitle(){
		log.info("Expected page title is : "+pageTitle);
		return pageTitle;
	}

}



