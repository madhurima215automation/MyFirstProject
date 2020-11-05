package Sanity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import io.appium.java_client.android.AndroidDriver;
import utilsPackage.navigator;
import utilsPackage.Utils;


public class userLogin {

		private RemoteWebDriver driver;
		private static Logger logger = Logger.getLogger(userLogin.class);
		
		
		@BeforeClass
		@Parameters({"runOn","systemPort"})
		public void setupInitialization(String runOn,String systemPort) throws MalformedURLException{
			Utils.initializeVariables();
			AndroidDriver androidDriver = new AndroidDriver(new URL(Utils.serverAddress),Utils.getCapabilities());
			driver = androidDriver;
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		@Test(priority = 1)
		public static void Test_logIn(WebDriver driver) {
		//To log In as an authorized User

			logger.info("User Log In");
			//Login
			
//			## Click on Sign In button to begin Sign in process
			driver.findElement(By.id(Utils.signInButtonId)).click();
			
//			## Enter your registered mobile number or email Id & click continue to proceed	
			
			driver.findElement(By.id(Utils.enterLoginId)).sendKeys(Utils.PhoneNo);
			driver.findElement(By.xpath(Utils.continueButton)).click();
			
//			## User lands to password authentication page, Enter password and click on submit
			
			driver.findElement(By.id(Utils.enterPasswordId)).sendKeys(Utils.password);
			driver.findElement(By.id(Utils.signInSubmitButtonId)).click();
			
//          ## Verify if user is landed to home page 
			Utils.makeThreadSleep(5000);
			driver.findElement(By.id(Utils.productSearchId)).isDisplayed();
			
			
			logger.info("User Logged In Succesfully");
			logger.error("Error occured during User loggin");
			
			
			Utils.makeThreadSleep(5000);
			navigator.screenshot(driver, userLogin.class.getSimpleName());
			
			
			
			
		
		}
		@Test(priority = 1)
		public void productPurchase() {
			
			
		
		}
		@AfterClass
		public void setupRemoval(){
			driver.quit();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

