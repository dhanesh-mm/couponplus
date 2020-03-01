package io.couponplus.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.couponplus.generic.WebdriverCommonLib;

public class StorBasePage {
	WebDriver driver;
	WebdriverCommonLib wlib= new WebdriverCommonLib(driver);
	String Inventry= null;

	@FindBy(xpath="//*[text()='Dashboard']")
	private WebElement Dashboard;

	@FindBy(xpath="//*[text()='Manage Coupon']")
	private WebElement ManageCoupon;


	@FindBy(xpath="//*[@class=\"lightgallery1 lightGallery\"]/../../td[10]")
	private WebElement Inventory;

	@FindBy(xpath="//*[text()='Redeemed/Not Redeemed Coupons']/../*[@class=\"mb-0\"]")
	private WebElement redeemValue;

	@FindBy(xpath="//*[@id=\"coupon\"]")
	private WebElement couponField;

	@FindBy(xpath="//*[text()='Apply Coupon']")
	private WebElement apply;

	public StorBasePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void NavigateToStore() throws InterruptedException
	{
		ManageCoupon.click();
		Thread.sleep(2000);
		Inventry = Inventory.getText();
		//		System.out.println(Inventry);

	}
	public String inventoryQuant() throws InterruptedException
	{
		return Inventry;
	}
	public void redeemCoupon(String value) throws InterruptedException
	{
		Dashboard.click();
		Thread.sleep(5000);
		String beforReddem = redeemValue.getText();
		Thread.sleep(2000);
		couponField.sendKeys(value);
		Thread.sleep(2000);
		apply.click();
		Thread.sleep(4000);
		String afterReddem = redeemValue.getText();
		Reporter.log("Before Redeem Coupon Status: "+beforReddem+" , After Redeem Coupon Status:  "+afterReddem, true);
		//System.out.println("Before Redeem: "+beforReddem+" , After Redeem:  "+afterReddem);
		Reporter.log("Coupon redeemed successfully",true);
	}






}
