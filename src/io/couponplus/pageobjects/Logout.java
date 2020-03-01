package io.couponplus.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.couponplus.generic.WebdriverCommonLib;

public class Logout {
	WebDriver driver;
	WebdriverCommonLib wlib= new WebdriverCommonLib(driver);

	@FindBy(xpath="//*[@class=\"dropdown-toggle\"]")
	private WebElement Profile;


	@FindBy(xpath="//*[text()=\" Logout\"]")
	private WebElement Logout;

	@FindBy(xpath="//*[@id=\"profileDropdown\"]")
	private WebElement StrProfile;

	@FindBy(xpath="//*[@onclick=\"event.preventDefault(); document.getElementById('frm-logout').submit();\"]")
	private WebElement StrLogout;


	public Logout (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void custLogOut() throws InterruptedException
	{
		Thread.sleep(5000);
		Profile.click();
		Thread.sleep(2000);
		Logout.click();
		Reporter.log("Customer logout successfully",true);

	}
	public void storLogOut() throws InterruptedException
	{
		Thread.sleep(5000);
		StrProfile.click();
		Thread.sleep(3000);
		StrLogout.click();
		Reporter.log("Store user logout successfully",true);

	}

}
