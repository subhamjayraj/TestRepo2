package com.redbus.pages;

import org.openqa.selenium.WebDriver;

public class WaitHelper {
	
	WebDriver driver;
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
	}

	public static void ThreadWait(long second){
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
}
