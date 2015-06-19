package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsListPage {

	WebDriver driver;
	

	
	
	@FindBy(id="resultsBlock")
	WebElement hotelsList ;
	
	@FindBy(className="locAndDate")
	WebElement HeadingInput ;

	public HotelsListPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	public int HotelDetailsHavingMinimumPrice(){
		List<WebElement> rows=hotelsList.findElement(By.className("HotelsList")).findElements(By.tagName("li")); 
		
		int mini = 10000;
		int price = 0;
		for (int i=0;i<rows.size();i+=8) {
			 price = Integer.parseInt(RemoveCommaInPrice( rows.get(i).findElement(By.className("ReducedFare")).getText()));
			if( price < mini )
				mini=price ;			
		}	
		System.out.println("------------Minimum hotel price----"+ mini );
		return mini;
		
	}

	public static  String RemoveCommaInPrice(String str){
		return str.replaceAll(",", "");	
	}
	
	public boolean verfyHeadingInputPresent(){
		return HeadingInput.isDisplayed();		
	}
	
	
}
