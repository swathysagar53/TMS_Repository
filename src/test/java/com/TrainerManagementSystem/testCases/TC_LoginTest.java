package com.TrainerManagementSystem.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TrainerManagementSystem.pageObjects.LoginPage;
import com.TrainerManagementSystem.utilities.XLUtility;



public class TC_LoginTest extends BaseClass
{

    @Test(dataProvider="LoginData")
	public void LoginTest(String user,String pwd) throws InterruptedException
	{
		
	
		LoginPage obj=new LoginPage(driver);
		
		obj.setUserName(user);
		logger.info("Entered username");
		obj.setPassword(pwd);
		logger.info("Entered password");
		obj.clickLoginButton();
		Thread.sleep(3000);
		
		if(driver.getCurrentUrl().equals("https://trainermanagement.herokuapp.com/profile"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			obj.clickTrainerLogoutButton();
			Thread.sleep(3000);
			obj.clickLogin();
			driver.switchTo().defaultContent();
			Reporter.log("<br>LoginTest:: Login test passed</br>");
			
		}
		else if(driver.getCurrentUrl().equals("https://trainermanagement.herokuapp.com/admin"))
		{   
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
			obj.clickLogoutButton();
			obj.clickLogin();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Reporter.log("<br>LoginTest:: Login test passed</br>");
			
		}
		else if(obj.WarningMsg()==true) {
			
			logger.warn("Login test failed");
			Assert.assertTrue(false);
			Reporter.log("<br>LoginTest:: Login test failed</br>");
		}
		else {
			
			logger.warn("Login test failed");
			Assert.assertTrue(false);
			Reporter.log("<br>LoginTest:: Login test failed</br>");
		}
	}
		
		
		
    @DataProvider(name="LoginData")
    String [][] getData() throws IOException
    {
    	String path=System.getProperty("user.dir")+"/src/test/java/com/TrainerManagementSystem/testData/LoginData.xlsx";
    	int rownum=XLUtility.getRowCount(path, "Sheet1");
    	int colcount=XLUtility.getCellCount(path, "Sheet1", 1);
    	
    	String logindata[][]=new String[rownum][colcount];
    	for(int i=1;i<=rownum;i++) {
    		for(int j=0;j<colcount;j++) {
    			
    			logindata[i-1][j]=XLUtility.getCellData(path, "Sheet1", i, j);
    		}
    	}
    return logindata;	
    }
}
