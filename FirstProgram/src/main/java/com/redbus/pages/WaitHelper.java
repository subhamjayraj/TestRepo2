package com.redbus.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class WaitHelper {
	
	private static final Logger log = Logger.getLogger(WaitHelper.class);
	WebDriver driver;
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
	}

	public static void ThreadWait(long second){
		try {
			Thread.sleep(second * 1000);
			log.info("Thread wait for "+second+" seconds");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
}
