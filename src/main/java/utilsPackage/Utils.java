package utilsPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Utils {

	public static Properties xPaths,elementIds,dynamicContent;
	public static DesiredCapabilities capabilities;
	
	//Dynamic Content
	public static String appPackage;
	public static String appActivity;
	public static String serverAddress;
	public static String platformName;
	public static String deviceName;
	public static String automationName;
	public static String udid;
	public static String PhoneNo;
	public static String password;
	public static String platformVersion;
	public static String paymentPin;
	public static String Product;
	//By ID
	public static String signInButtonId;
	public static String enterLoginId;
	public static String enterPasswordId;
	public static String signInSubmitButtonId;
	public static String productSearchId;
	public static String selectedProduct;
	
	//By xpath
	public static String amazonLogo;
	public static String continueButton;
	public static String searchButton;
	public static String tvNameDetails;
	public static String tvPrice;
	public static String buyNowButton;
	public static String cardPinTextBox;
	public static String continuePurchaseButton;
	public static String tvPriceAtCheckOut;
	public static String tvNameDetailsAtCheckout;
	
	
	
	
	public static void initializeVariables(){
		dynamicContent = Utils.getDynamicContent();
		xPaths = Utils.getXpaths();
		elementIds = Utils.getElementId();
		// Dynamic Content
		serverAddress = dynamicContent.getProperty("serverAddress");
		
		appPackage = dynamicContent.getProperty("appPackage");
		appActivity = dynamicContent.getProperty("appActivity");
		platformName = dynamicContent.getProperty("platformName");
		deviceName = dynamicContent.getProperty("deviceName");
		automationName = dynamicContent.getProperty("automationName");
		udid = dynamicContent.getProperty("udid");
		PhoneNo = dynamicContent.getProperty("PhoneNo");
		password = dynamicContent.getProperty("password");
		platformVersion = dynamicContent.getProperty("platformVersion");
		platformVersion = dynamicContent.getProperty("Product");
		
		//ID
		signInButtonId = elementIds.getProperty("signInButtonId");
		
		enterLoginId = elementIds.getProperty("enterLoginId");
		enterPasswordId = elementIds.getProperty("enterPasswordId");
		signInSubmitButtonId = elementIds.getProperty("signInSubmitButtonId");
		productSearchId = elementIds.getProperty("productSearchId");
		selectedProduct = elementIds.getProperty("selectedProduct");
		
		//xPaths
		continueButton = xPaths.getProperty("continueButton");
		
		amazonLogo = xPaths.getProperty("amazonLogo");
		continueButton = xPaths.getProperty("continueButton");
		searchButton = xPaths.getProperty("searchButton");
		tvNameDetails = xPaths.getProperty("tvNameDetails");
		tvPrice = xPaths.getProperty("tvPrice");
		buyNowButton = xPaths.getProperty("buyNowButton");
		cardPinTextBox = xPaths.getProperty("cardPinTextBox");
		continuePurchaseButton = xPaths.getProperty("continuePurchaseButton");
		tvPriceAtCheckOut = xPaths.getProperty("tvPriceAtCheckOut");
		tvNameDetailsAtCheckout = xPaths.getProperty("tvNameDetailsAtCheckout");
	
	}
	
	
		public static DesiredCapabilities getCapabilities(){
			
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("udid", udid);
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
			return capabilities;
		}
	
		public static Properties getDynamicContent(){
			dynamicContent = new Properties();
			String propFileName = "src/test/resources/dynamicContent.properties";
			InputStream inputStream;
			try {
				inputStream = new FileInputStream(propFileName);
				dynamicContent.load(inputStream);
			} 
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dynamicContent;
		}
		
		
		public static Properties getElementId(){
			elementIds = new Properties();
			String propFileName = "src/test/resources/elementId.properties";
			InputStream inputStream;
			try {
				inputStream = new FileInputStream(propFileName);
				elementIds.load(inputStream);
			} 
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return elementIds;
		}
		
		
		public static Properties getXpaths(){
			xPaths = new Properties();
			String propFileName = "src/test/resources/xPaths.properties";
			InputStream inputStream;
			try {
				inputStream = new FileInputStream(propFileName);
				xPaths.load(inputStream);
			} 
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return xPaths;
	
		}
		public static void makeThreadSleep(int time){
			try {
				System.out.printf("sleeping for %d ms\n",time);
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	
	
	
	
	
	
	
	
}
