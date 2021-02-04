package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.BaseTest;

public class CreateNewAccountTest extends BaseTest {
	
	@BeforeTest
	public void setUp(){
		launchApplication();
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="CreateNewAccount",enabled=true,alwaysRun=true)
	public void createNewAccountTest(String firstName,String lastName,String mobileNumber,String password,String dob,String gender){
		getSignUpPage().clickOnCreateNewAccount().
		enterFirstName(firstName).enterSurName(lastName)
		.enterMobileOrEmailAddress(mobileNumber)
		.enterPassword(password)
		.selectDOB(dob)
		.selectGender(gender).clickOnSignUp();
		
		String actualRegError = getSignUpPage().getRegError();
		Assert.assertEquals(actualRegError, "Too many users have this phone number listed as pending.","The Reg error is not matching");
	}
	
	@AfterTest
	public void quiteBrowser(){
		getDriver().close();
	}

}

