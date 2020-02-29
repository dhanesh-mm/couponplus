package io.couponplus.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebdriverCommonLib 
{
	WebDriver driver;
	public WebdriverCommonLib(WebDriver driver)
	{
		this .driver = driver;
	}

	/**********************************enter data in to textbox ************************/

	public void enterData(WebElement ele, String input)
	{
		ele.clear();
		ele.sendKeys(input);
	}
	/************************************select checkbox********************************/

	public void clickChkBx(WebElement chkBx)
	{
		if(chkBx.isSelected()) 
		{
			Reporter.log("Check box is selected",true);
		}
		else  
		{
			chkBx.click();
		}
	}

	/******************slecet dropdown option using text**********************/

	public void selectOptionText(WebElement drpDwn, String optionText)
	{
		Select sel = new Select(drpDwn);
		sel.selectByVisibleText(optionText);

	}

	/***************mouse overing************************/

	public void mouseOver(WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	/***************************explicitWait***************************/

	public void eWaitVisible(int secs, WebElement ele)
	{
		WebDriverWait  wait = new WebDriverWait(driver, secs) ; 
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/*******************scroll till webElement is visible********************************/

	public void scrollView(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();",ele);
	}
}
