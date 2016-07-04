package com.redbus.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
		DesiredCapabilities cap =  DesiredCapabilities.firefox() ;
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		//	driver=new FirefoxDriver();
		try {
			driver= new RemoteWebDriver(new URL("http://192.168.1.106:4444/wd/hub") , cap);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");

		log.info("Launching Redbus in browser");

		//	driver.findElement(By.className("signin-screen")).click();
		driver.findElement(By.className("modalFrame")).findElement(By.className("modalCloseSmall")).click();
		Thread.sleep(4000);
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
