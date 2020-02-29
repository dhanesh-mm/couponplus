package io.couponplus.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib 
{

    WebDriver driver;
    /***Constructor****/
    public WaitStatementLib(WebDriver driver)
    {
    	this.driver=driver;
    	
    }
    /**********HardCodeWait****************/
    public void iSleep(int secs)
    {
    	try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /***********ImplicitWait for seconds**********/
    
    public void iWaitForSecs(int secs)
    {
    	driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
    }
    /*************ExplicitWait*************/
    
    public void eWaitforVisible(int secs, WebElement ele)
    {
    	WebDriverWait wait= new WebDriverWait(driver,secs);
    	wait.until(ExpectedConditions.visibilityOf(ele));
    	
    }
    
	/**********ExplicitWait Refresh And Check for Condition******/
    public void eWaitRefreshCondition(int secs, WebElement ele)
    {
    	WebDriverWait wait= new WebDriverWait(driver,secs);
    	wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
    
    }   
    
}



