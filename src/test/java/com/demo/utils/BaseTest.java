package com.demo.utils;
import org.openqa.selenium.WebDriver;
import com.demo.pages.SignUpPage;


public class BaseTest {
	
	private WebDriver driver;
	BasePage basePage;
	SignUpPage signUpPage;

	
	public void launchApplication(){
		driver=new BrowserCreation().createBrowser();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public BasePage getBasePage() {
	    if (basePage == null) {
	      basePage = new BasePage(driver);
	    }
	    return basePage;
	}
	
	public SignUpPage getSignUpPage() {
	    if (signUpPage == null) {
	    	signUpPage = new SignUpPage(driver);
	    }
	    return signUpPage;
	}
	
	
}
