package io.couponplus.scripts;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.couponplus.generic.BaseLib;
import io.couponplus.generic.PdfReader;
import io.couponplus.pageobjects.CustBasePage;
import io.couponplus.pageobjects.Login;
import io.couponplus.pageobjects.Logout;
import io.couponplus.pageobjects.StorBasePage;

public class testScript extends BaseLib {
	String beforeQuantInvent= null;
	String quantityNum = null;

	@Test( priority = 1,description = "login with valid credentials in Store")
	@Parameters({"emailstr", "passwordstr" })
	public void beforeCouponPurchase( String EmailStr, String PwdStr) throws InterruptedException
	{
		Login log = new Login(driver);
		log.storeLogin(EmailStr, PwdStr);
		Thread.sleep(2000);
		StorBasePage stor= new StorBasePage(driver);
		stor.NavigateToStore();
		Thread.sleep(2000);
		beforeQuantInvent = stor.inventoryQuant();
		Reporter.log("Inventory count before coupon purchase: "+beforeQuantInvent , true );
		Logout lg = new Logout(driver);
		lg.storLogOut();
	}

	@Test( priority = 2,description = "Search Product")
	@Parameters({"email", "password","product","addproduct" })
	public void customerCouponPurchase(String Email, String Pwd, String productname,int addproduct) throws InterruptedException {

		Login log = new Login(driver);
		log.customerLogin(Email, Pwd);
		CustBasePage cust = new CustBasePage(driver);
		Thread.sleep(2000);
		cust.searchProduct(productname);
		cust.addToCart(addproduct);
		cust.purchaseItem();
		cust.couponDownload();
		quantityNum = cust.quantityNum();
		Reporter.log("Quantity of coupon purchased: "+quantityNum , true );
		Logout lg = new Logout(driver);
		lg.custLogOut();
	}

	@Test( priority = 3,description = "login with valid credentials in Store")
	@Parameters({"emailstr", "passwordstr", "path", "product" })
	public void redeemCoupon( String EmailStr, String PwdStr, String path, String product) throws InterruptedException
	{
		Login log = new Login(driver);
		log.storeLogin(EmailStr, PwdStr);
		Thread.sleep(2000);
		StorBasePage stor= new StorBasePage(driver);
		stor.NavigateToStore();
		String afterQuantInvent = stor.inventoryQuant();
		Reporter.log("Inventory count after coupon purchase: "+afterQuantInvent , true );

		PdfReader pdf= new PdfReader();
		pdf.reader(path, product);
		String couponCode = (String) pdf.couponVal();

		Reporter.log("Coupan code is : "+ couponCode);
		stor.redeemCoupon(couponCode);
		Thread.sleep(2000);
	}



}