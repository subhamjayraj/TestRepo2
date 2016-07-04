package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsListPage {

	WebDriver driver;	

	@FindBy(id="hotel_items")
	WebElement hotelsList ;

	@FindBy(id="hotels_meta")
	WebElement HeadingInput ;

	public HotelsListPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public int HotelDetailsHavingMinimumPrice(){
		List<WebElement> rows=hotelsList.findElements(By.tagName("li")); 
		System.out.println("------------Minimum hotel price----"+ rows.size() );
		int mini = 10000;
		int price = 0;
		for (WebElement e : rows) {
			WebElement el = e.findElement(By.cssSelector("div.fl.w-65.hotel-details")).findElement(By.className("oh"))
					.findElement(By.cssSelector("div.fl.w-25.price-info")).findElement(By.className("new-fare"));			 
			price = Integer.parseInt(el.getText().trim().substring(4));			
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
