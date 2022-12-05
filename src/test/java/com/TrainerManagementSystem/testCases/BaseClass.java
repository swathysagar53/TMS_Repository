package com.TrainerManagementSystem.testCases;





import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.TrainerManagementSystem.utilities.ReadConfig;

public class BaseClass {
	
    ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String pwd=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String bwsr)
	{
		
		logger= Logger.getLogger("Trainer Management System");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(bwsr.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(bwsr.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(bwsr.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver=new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		logger.info("URL is opened");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
