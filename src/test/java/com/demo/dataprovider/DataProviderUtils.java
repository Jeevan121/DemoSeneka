package com.demo.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.demo.utils.ExcelUtils;





public class DataProviderUtils {
	
	@DataProvider(name = "CreateNewAccount")
	  public static Object[][] loginAnProfileDetailsValidationTest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "CreateNewAccount");
	    return objReturn;
	  }
	
		
	
}
