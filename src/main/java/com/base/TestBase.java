package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.util.TestUtil;
import com.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static Logger log;
	
	public static ExtentReports extent;
	 public static ExtentTest logger;

	
	public TestBase() {
		
		log= Logger.getLogger("TestBase");
		 PropertyConfigurator.configure("log4j.properties");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\Project\\Shopping\\src\\main\\java\\com\\config\\config.properties");
			prop.load(ip);				
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	 
	
public static void initialization() {
			 
	String browserName = prop.getProperty("browser");
	
	if (browserName.equals("chrome")) {
		log.info("Launching the Chrome...");
		System.setProperty("webdriver.chrome.driver", "D:\\java\\Chromedriver\\chromedriver84.exe");
		driver = new ChromeDriver();
	} 
	else if (browserName.equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver", "E:\\java\\Selenium Software\\geckodriver.exe");
		driver = new FirefoxDriver();	
	}	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	}
}