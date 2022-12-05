package com.TrainerManagementSystem.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.TrainerManagementSystem.pageObjects.SignUpPage;
import com.TrainerManagementSystem.utilities.XLUtility;

public class TC_SignUp extends BaseClass {
	
    @Test(dataProvider="SignupData")
	public void SignUpTest(String name,String email, String MbNo, String address, String qualification, String skill, String cmpname, String currentdesig, String photopath,String course, String pwd, String repwd) throws InterruptedException
	{
			
		
	SignUpPage obj1=new SignUpPage(driver);
			
	        obj1.SignUp();
			obj1.TrainerName(name);
			logger.info("Entered name");
			obj1.TrainerEmail(email);
			logger.info("Entered email");
			obj1.TrainerMobileNo(MbNo);
			Thread.sleep(3000);
			obj1.TrainerAddress(address);
			obj1.TrainerQualification(qualification);
			obj1.TrainerSkillSet(skill);
			obj1.TrainerCompanyName(cmpname);
			obj1.TrainerCurrentDesignation(currentdesig);
			Thread.sleep(3000);
			obj1.TrainerPhotoUpload(photopath);
			logger.info("Entered img path");
			obj1.TrainerCourses(course);
			logger.info("Entered course");
			Thread.sleep(3000);
			obj1.TrainerPassword(pwd);
			logger.info("Entered password");
			obj1.TrainerRetypepassword(repwd);
			Thread.sleep(3000);
			obj1.Submit();
			logger.info("Submitted");
			
			if(obj1.isAlertPresent()==true) {
				Assert.assertTrue(true);
				Reporter.log("<br>SignUpTest:: Sign Up test passed</br>");
				obj1.SignUp();
				driver.switchTo().defaultContent();
			}
			else {
				
				Assert.assertTrue(false);
				Reporter.log("<br>SignUpTest:: Sign Up test failed</br>");
			}
			
	}
    
    
    @DataProvider(name="SignupData")
    String [][] getData() throws IOException
    {
    	String path=System.getProperty("user.dir")+"/src/test/java/com/TrainerManagementSystem/testData/SignUpData.xlsx";
    	int rownum=XLUtility.getRowCount(path, "Sheet1");
    	int colcount=XLUtility.getCellCount(path, "Sheet1", 1);
    	
    	String signupdata[][]=new String[rownum][colcount];
    	for(int i=1;i<=rownum;i++) {
    		for(int j=0;j<colcount;j++) {
    			
    			signupdata[i-1][j]=XLUtility.getCellData(path, "Sheet1", i, j);
    		}
    	}
    return signupdata;	
    }

}
