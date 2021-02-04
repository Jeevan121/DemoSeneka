package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.demo.utils.BasePage;

public class SignUpPage extends BasePage{
	
	WebDriver driver;
	public SignUpPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}

	private By createNewAccountBtn = new By.ByXPath("//a[contains(text(),'Create New Account')]");
	private By firstNameTxt = new By.ByName("firstname");
	private By surNameTxt = new By.ByName("lastname");
	private By mobileNumberTxt = new By.ByXPath("//input[contains(@aria-label,'Mobile number')]");
	private By passwordTxt = new By.ByXPath("//input[contains(@id,'password')]");
	
	//date of birth locators
	private By daySclt = new By.ByXPath("//select[@id='day']");
	private By monthSclt = new By.ByXPath("//select[@id='month']");
	private By yearSclt = new By.ByXPath("//select[@id='year']");
	
	private By regErrorLabel = new By.ByXPath("//div[@id='reg_error_inner']");
	
	private By signUpBtn = new By.ByXPath("(//button[contains(text(),'Sign Up')])[position()=1]");
	
	public SignUpPage clickOnCreateNewAccount(){
		safeClick(createNewAccountBtn);
		return this;
	}
	
	public SignUpPage enterFirstName(String firstName){
		safeType(firstNameTxt, firstName);
		return this;
	}
	
	public SignUpPage enterSurName(String lastName){
		safeType(surNameTxt, lastName);
		return this;
	}
	
	public SignUpPage enterMobileOrEmailAddress(String mobileOrEmailId){
		safeType(mobileNumberTxt, mobileOrEmailId);
		return this;
	}
	
	public SignUpPage enterPassword(String password){
		safeType(passwordTxt, password);
		return this;
	}
	
	public SignUpPage selectDOB(String dob){
		
		String[] dateOfBirth = dob.split(",");
		
		Select daySlt = new Select(driver.findElement(daySclt));
		daySlt.selectByVisibleText(dateOfBirth[0]);
		
		Select monthSlt = new Select(driver.findElement(monthSclt));
		monthSlt.selectByVisibleText(dateOfBirth[1]);
		
		Select yearSlt = new Select(driver.findElement(yearSclt));
		yearSlt.selectByVisibleText(dateOfBirth[2]);
		return this;
	}
	
	public SignUpPage selectGender(String gender){
		By genderRadio = new By.ByXPath("//label[text()='"+gender+"']/following-sibling::input[@name='sex']");
		safeClick(genderRadio);
		return this;
	}
	
	public SignUpPage clickOnSignUp(){
		safeClick(signUpBtn);
		return this;
	}
	
	public String getRegError(){
		String error = getText(regErrorLabel);
		return error;
	}
}
