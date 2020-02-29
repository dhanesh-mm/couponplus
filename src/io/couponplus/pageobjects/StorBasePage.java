package io.couponplus.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.couponplus.generic.WebdriverCommonLib;

public class StorBasePage {
	WebDriver driver;
	WebdriverCommonLib wlib= new WebdriverCommonLib(driver);

	@FindBy(xpath="//*[text()='Dashboard']")
	private WebElement Dashboard;



	@FindBy(xpath="//*[text()='Manage Coupon']")
	private WebElement ManageCoupon;


	@FindBy(xpath="//*[@class=\"lightgallery1 lightGallery\"]/../../td[10]")
	private WebElement Inventory;
	
	public StorBasePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void NavigateToStore() throws InterruptedException
	{
		ManageCoupon.click();
		Thread.sleep(2000);
		String Inventry = Inventory.getText();
		System.out.println(Inventry);
	}
}
