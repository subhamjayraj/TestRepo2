package com.redbus.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFramePage {

	private static final Logger log = Logger.getLogger(LoginFramePage.class);
	
	
	WebDriver driver;
	
	@FindBy(linkText="SIGN IN")
	WebElement signInLink ;
	
	@FindBy(id="email-mobile")
	WebElement EmailMobileLink ;
	
	@FindBy(id="password")
	WebElement passwordLink ;
	
	@FindBy(id="doSignin")
	WebElement SignInButton ;
	
	public LoginFramePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn(){
		log.info("Clicking on SIGN IN");
		signInLink.click();
		WaitHelper.ThreadWait(2);
	}
	public void setEmailMobile(String emailMobile){
		log.info("Entering Email as : "+emailMobile);
		EmailMobileLink.sendKeys(emailMobile);
	}
	public void setPassword(String password){
		log.info("Entering Password as : "+password);
		passwordLink.sendKeys(password);
	}
	
	public HomePage clickOnSignInButton(){
		log.info("Clicking on SIGN IN button");
		SignInButton.click();
		return new HomePage(driver);
	}
	
	
}
