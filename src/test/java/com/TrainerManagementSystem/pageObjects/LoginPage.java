package com.TrainerManagementSystem.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver localdriver;
	
	public LoginPage(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(name="email")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Pwd;
	
	@FindBy(xpath="/html/body/app-root/app-login/main/form/button")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul/li[4]/a")
	@CacheLookup
	WebElement LogoutBtn;
	
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul/li[2]/a")
	@CacheLookup
	WebElement Login;
	
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul/li[3]/a")
	@CacheLookup
	WebElement TrainerLogoutBtn;
	
	@FindBy(xpath="/html/body/app-root/app-login/main/div")
	@CacheLookup
	WebElement WarnMsg;
	
	
	public boolean WarningMsg(){
		
		WebDriverWait wait = new WebDriverWait(localdriver,Duration.ofSeconds(5));
		WebElement el= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-login/main/div")));
	    	boolean ms=	el.isDisplayed();
			return ms;
		
	}
	
	
	//Action methods
	public void setUserName(String uname) {
		UserName.clear();
		UserName.sendKeys(uname);
	}
	
   public void setPassword(String pwd) {
		Pwd.clear();
		Pwd.sendKeys(pwd);
	}
   
   public void clickLoginButton() {
		
		LoginBtn.click();
	}
   
   public void clickLogoutButton() {
		
		LogoutBtn.click();
	}
   public void clickTrainerLogoutButton() {
		
		TrainerLogoutBtn.click();
	}
  
   
   public void clickLogin() {
	   Login.click();
   }
   
	
}
