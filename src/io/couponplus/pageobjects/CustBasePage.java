package io.couponplus.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.couponplus.generic.WaitStatementLib;
import io.couponplus.generic.WebdriverCommonLib;

public class CustBasePage {
	WebDriver driver;
	WebdriverCommonLib wlib= new WebdriverCommonLib(driver);
	WaitStatementLib wait = new WaitStatementLib(driver);

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

	
	public CustBasePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void navigateToCustPage(String productname) throws InterruptedException
	{
		searchField.sendKeys(productname);
		searchButton.click();
		Thread.sleep(4000);
		prd.click();
		Thread.sleep(2000);
		AddtoCart.click();
		Thread.sleep(2000);
		YourCart.click();
		Thread.sleep(2000);
		ButtonPlus.click();
		ButtonPlus.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		String quantity = Quantity.getAttribute("max-value");
		System.out.println(quantity);
		SelectCard.click();
		Proceed.click();
	}

}
