package com.redbus.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;





public class BaseTest {

	public WebDriver driver ;
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.redbus.in");
	//	WaitHelper.ThreadWait(8);
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
