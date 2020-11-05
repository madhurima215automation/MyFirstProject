package Sanity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import utilsPackage.Utils;
import utilsPackage.navigator;

public class productPurchase {
	
	private RemoteWebDriver driver;
	private static Logger logger = Logger.getLogger(productPurchase.class);
	
	
	@BeforeClass
	@Parameters({"runOn","systemPort"})
	public void setupInitialization(String runOn,String systemPort) throws MalformedURLException{
		Utils.initializeVariables();
		AndroidDriver androidDriver = new AndroidDriver(new URL(Utils.serverAddress),Utils.getCapabilities(runOn,systemPort));
		driver = androidDriver;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void productSelect() throws InterruptedException {
		
//      ## Call and reuse user Log In method
		userLogin.Test_logIn(driver);
		
//      ##Search for 65 inch TV and select A TV 
	
		
		driver.findElement(By.id(Utils.productSearchId)).sendKeys(Utils.Product);
		driver.findElement(By.xpath(Utils.searchButton)).click();
		driver.findElement(By.id(Utils.selectedProduct)).click();
		driver.findElement(By.xpath(Utils.searchButton)).click();
		
		logger.info("User Is in Product details page");
		
//      ## User checks for details
//      ## extract product details and price
		String TVName =driver.findElement(By.xpath(Utils.tvNameDetails)).getText();
		String TVPrice =driver.findElement(By.xpath(Utils.tvPrice)).getText();
				
		System.out.println("Product Name & Description: "+TVName);
		System.out.println("Product Price details: "+TVPrice);
//      ## Swipe down to click on Buy now
		Thread.sleep(10000);
		navigator.verticalSwipe(driver, 0.80, 0.40);
				
		driver.findElement(By.xpath(Utils.buyNowButton)).click();	
		
//      ## Payment page Enter payement pin
		
		driver.findElement(By.xpath(Utils.cardPinTextBox)).click();
		driver.findElement(By.xpath(Utils.cardPinTextBox)).sendKeys(Utils.paymentPin);
		
		logger.info("wait for swipe up to find continue button");
		// Swipe up
		Thread.sleep(10000);
		navigator.verticalSwipe(driver, 0.20, 0.80);
		
		driver.findElement(By.xpath(Utils.continuePurchaseButton)).click();
		
//      ## Checkout page product
		
		String TVPriceCheckout = driver.findElement(By.xpath(Utils.tvPriceAtCheckOut)).getText();
		System.out.println("The Final price to verify : "+TVPriceCheckout);
		
//      ## Swipe down to check product details
		Thread.sleep(10000);
		navigator.verticalSwipe(driver, 0.80, 0.30);
		
		String TVNameDetailsCheckout = driver.findElement(By.xpath(Utils.tvNameDetailsAtCheckout)).getText();
		System.out.println("The TV Name and Details to cross verify : "+TVNameDetailsCheckout);
		
		
//      ## Verification of Product Name, details and Price
		Reporter.log("The Product Details is correct", true);
		Assert.assertEquals(TVNameDetailsCheckout, TVName);
		
		
		
		Reporter.log("The Product Details is correct", true);
		Assert.assertEquals(TVPriceCheckout, TVPrice);
		
		
		
		
	}
	
	
	@AfterClass
	public void setupRemoval(){
		Reporter.log("Driver Closed After Testing");
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	

}
