package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusListPage {

	WebDriver driver;
	String pageTitle = "Book Ticket - Search Buses";

	@FindBy(className="PrivateBuses")
	WebElement privateBuses ;
	
	@FindBy(id="mod_search")
	WebElement modifyLink ;

	public BusListPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public boolean verifyBusListPageTitle(String title){
		return pageTitle.equalsIgnoreCase(title) ;
	}

	public int BusDetailsHavingMinimumPrice(){
		int mini = 10000;
		int index =0 ;
		List<WebElement> list1 = privateBuses.findElements(By.tagName("li"));

		for(int i=0;i<list1.size(); i+=4){
			int price = Integer.parseInt(CheckForRange( list1.get(i).findElement(By.className("fareSpan")).getText().substring(3))) ;
			if( price < mini ){
				mini=price ;
				index =i/4;
			}			
		}
		System.out.println("------------Minumum Price---"+ mini+" at index "+index );
		return mini;
	}

	public  String CheckForRange(String str){
		if(str.contains("/"))
			return str.substring(0, str.indexOf("/"));		
		else
			return str;
	}
	
	public boolean verfyModifyLinkPresent(){
		return modifyLink.isDisplayed();		
	}
}
