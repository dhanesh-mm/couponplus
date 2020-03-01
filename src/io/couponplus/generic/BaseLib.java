package io.couponplus.generic;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLib 
{
	public static WebDriver driver;

	@BeforeTest
	@Parameters({"browser", "baseurl"})
	public void stUp(String browserName, String url)
	{
		if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log("firefox launched",true);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("chrome is launched",true);
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			Reporter.log("ie launched",true);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Reporter.log(url+"url navigated",true);
	}


	@AfterClass
	public void TearDown()
	{
		driver.close();
		Reporter.log("browser closed",true);
	}


	@AfterMethod
	public void postConditions(ITestResult result)                
	{
		String scriptName = result.getMethod().getMethodName();	
		if(result.isSuccess())       
		{
			Reporter.log(scriptName+" script is passed:)", true);
		}
		else                      
		{
			Reporter.log(scriptName+" script is failed:(", true);
			ScreenShotLib slib = new ScreenShotLib(driver);
			slib.takeScreenshot(scriptName);
			Reporter.log("Screenshot has been taken",true);
		}
	}

}



