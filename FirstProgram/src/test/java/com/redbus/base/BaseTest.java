package com.redbus.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class BaseTest {

	private static final Logger log = Logger.getLogger(BaseTest.class) ;


	public WebDriver driver ;


	@BeforeSuite
	public void initilizeTestSuite(){
		PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");

	}


	@BeforeClass
	public void setUp() throws InterruptedException{

		log.info(" ---------- Start of the Test Case : "+this.getClass().getSimpleName()+" ---------- ");

		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.redbus.in");

		log.info("Launching Redbus in browser");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException, InterruptedException{

		log.info("--------- in @AfterMethod -----------");
		
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("F:\\image_"+System.nanoTime()/10000+".png") );
		}
	}

	@AfterClass(alwaysRun =true)
	public void tearDown(){
		log.info("Quiting the browser");
		driver.quit();
		log.info(" ---------- End of the Test Case : "+this.getClass().getSimpleName()+" ---------- ");
		log.info(" -------------------------------------------------------------------------------- ");
	}
}
