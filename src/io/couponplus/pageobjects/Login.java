package io.couponplus.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.couponplus.generic.WebdriverCommonLib;


public class Login {
	WebDriver driver;
	WebdriverCommonLib wlib= new WebdriverCommonLib(driver);

	@FindBy(xpath="//a[text()=' Login | Register']/b[text()='Customer :']")
	private WebElement CustSignIn;
	
	@FindBy(name="emaill")
	private WebElement EMail;


	@FindBy(name="passwordl")
	private WebElement Pswd;

	@FindBy(css="input[value='Login']")
	private WebElement Login;
	
	@FindBy(xpath="//a[text()=' Login | Register']/b[text()='Store :']")
	private WebElement StoreSignIn;
	
	@FindBy(name="loginEmail")
	private WebElement EMail1;


	@FindBy(name="password")
	private WebElement Pswd1;

	public Login (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void customerLogin(String Email,String Pwd) throws InterruptedException
	{
		Thread.sleep(5000);
		CustSignIn.click();
		Thread.sleep(2000);
		wlib.enterData(EMail, Email);
		wlib.enterData(Pswd, Pwd);
		Login.click();

	}
	public void storeLogin(String Email,String Pwd) throws InterruptedException
	{
		Thread.sleep(5000);
		StoreSignIn.click();
		Thread.sleep(2000);
		wlib.enterData(EMail1, Email);
		wlib.enterData(Pswd1, Pwd);
		Login.click();

	}

}
