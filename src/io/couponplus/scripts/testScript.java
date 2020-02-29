package io.couponplus.scripts;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.couponplus.generic.BaseLib;
import io.couponplus.pageobjects.CustBasePage;
import io.couponplus.pageobjects.Login;
import io.couponplus.pageobjects.Logout;
import io.couponplus.pageobjects.StorBasePage;

public class testScript extends BaseLib {


	@Test( priority = 1,description = "login with valid credentials in Store")
	@Parameters({"emailstr", "passwordstr" })
	public void BfrPurStr( String EmailStr, String PwdStr) throws InterruptedException
	{
		Login log = new Login(driver);
		log.storeLogin(EmailStr, PwdStr);
		Thread.sleep(2000);
		StorBasePage stor= new StorBasePage(driver);
		stor.NavigateToStore();
		Thread.sleep(2000);
		Logout lg = new Logout(driver);
		lg.storLogOut();
	}

	@Test( priority = 2,description = "Search Product")
	@Parameters({"email", "password","product" })
	public void Customer(String Email, String Pwd, String productname) throws InterruptedException {

		Login log = new Login(driver);
		log.customerLogin(Email, Pwd);
		CustBasePage cust = new CustBasePage(driver);
		Thread.sleep(2000);
		cust.navigateToCustPage(productname);
		Logout lg = new Logout(driver);
		lg.custLogOut();
	}
	
	@Test( priority = 3,description = "login with valid credentials in Store")
	@Parameters({"emailstr", "passwordstr" })
	public void AftrPurStr( String EmailStr, String PwdStr) throws InterruptedException
	{
		Login log = new Login(driver);
		log.storeLogin(EmailStr, PwdStr);
		Thread.sleep(2000);
		StorBasePage stor= new StorBasePage(driver);
		stor.NavigateToStore();
		Thread.sleep(2000);
		Logout lg = new Logout(driver);
		lg.storLogOut();
	}
}