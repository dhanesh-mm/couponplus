package io.couponplus.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.couponplus.generic.WaitStatementLib;
import io.couponplus.generic.WebdriverCommonLib;

public class CustBasePage {
	WebDriver driver;
	WebdriverCommonLib wlib= new WebdriverCommonLib(driver);
	WaitStatementLib wait = new WaitStatementLib(driver);
	String quantity= null;
	JavascriptExecutor jse = (JavascriptExecutor)driver;

	@FindBy(xpath="//*[@name='title']")
	private WebElement searchField;

	@FindBy(xpath="//*[@value='Search']")
	private WebElement searchButton;

	@FindBy(xpath="//*[@class=\"coupon_name\"]/../../../../../div[3]//*[text()=' Add to cart ']")
	private WebElement AddtoCart;

	@FindBy(xpath="//*[text()=' Your Cart ']")
	private WebElement YourCart;

	@FindBy(xpath="//*[@class='button-plus']")
	private WebElement ButtonPlus;

	@FindBy(xpath="//*[@data-value='4242']")
	private WebElement SelectCard;

	@FindBy(xpath="//*[text()='Proceed to pay']")
	private WebElement Proceed;

	@FindBy(xpath="//*[@id='currentQty']")
	private WebElement Quantity;

	@FindBy(xpath="//div[@class=\"coupon_img_box\"]")
	private WebElement prd;

	@FindBy(xpath="//*[text()='Visit My Coupon']")
	private WebElement viewCoupon;

	@FindBy(xpath="//*[@id=\"home\"]/div/div[1]/div/div[1]//div[5]//a")
	private WebElement printCoupon;

	@FindBy(xpath="//*[@class=\"dropdown-toggle\"]")
	private WebElement profile;

	@FindBy(xpath="//*[@onclick=\"event.preventDefault(); document.getElementById('my-coupon').submit();\"]")
	private WebElement myCoupon;


	public CustBasePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void searchProduct(String productname) throws InterruptedException
	{
		searchField.sendKeys(productname);
		searchButton.click();
		Thread.sleep(4000);
		prd.click();
		Reporter.log("Product searched successfully",true);


	}
	public void addToCart(int addproduct) throws InterruptedException{
		Thread.sleep(2000);
		AddtoCart.click();
		Thread.sleep(2000);
		YourCart.click();
		Thread.sleep(2000);

		for (int i = 1; i < addproduct; i++) {
			ButtonPlus.click();	

		}
		quantity = Quantity.getAttribute("value");
		System.out.println(quantity);
		Reporter.log("Product added to cart Successfully",true);

	}
	public void purchaseItem() throws InterruptedException
	{
		Thread.sleep(2000);
		SelectCard.click();
		Proceed.click();
		Thread.sleep(2000);
		try {
			jse.executeScript("scroll(0, 700);");
			Thread.sleep(2000);
			SelectCard.click();
			Thread.sleep(2000);
			Proceed.click();
			wait.iWaitForSecs(20);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void couponDownload() throws InterruptedException
	{
		Thread.sleep(2000);
		profile.click();
		Thread.sleep(2000);
		myCoupon.click();
		Thread.sleep(4000);
		try {
			jse.executeScript("scroll(0, 700);");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(3000);
		printCoupon.click();
		Thread.sleep(3000);
		Reporter.log("Coupon Downloaded successfully",true);
	}

	public String quantityNum() throws InterruptedException
	{
		return quantity;
	}

}
