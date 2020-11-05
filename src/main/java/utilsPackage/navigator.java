package utilsPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class navigator {

	public static int counter=1;
	
	

	public static void screenshot(WebDriver driver,String className){
		File srcFile=((AndroidDriver) driver).getScreenshotAs(OutputType.FILE);
		String filename = "ScreenShot-#" + ((Integer)counter).toString();
		counter++;
		String path_screenshot = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestScreenshots\\";
		File file = new File(path_screenshot+"\\"+className);
		if(!file.exists())
			file.mkdir();
		File targetFile = new File(file.getAbsolutePath()+ "\\" + filename +".jpg");
		try{
			FileUtils.copyFile(srcFile,targetFile);
		}catch(IOException e){
			e.printStackTrace();
		}
	
	
	
	
	
	}


	public static void verticalSwipe(RemoteWebDriver driver, double startpercentage, double finalPercentage) {
		// TODO Auto-generated method stub
		
			Dimension dim = driver.manage().window().getSize();
			int height = dim.getHeight();
			System.out.println("height "+height);
			int width = dim.getWidth();
			System.out.println("width "+width);
			int x = width/2;
			System.out.println("x "+x);
			int starty = (int)(height*startpercentage);System.out.println("starty "+starty);
			int endy = (int)(height*finalPercentage);System.out.println("endy "+endy);
			//driver.swipe(x, starty, x, endy, 500);
			new TouchAction((PerformsTouchActions) driver)
	        .press(PointOption.point(x,starty))
	        .moveTo(PointOption.point(x, endy))
	        .release()
	        .perform();
			System.out.println("swipe done");
			
		
	}
	
}
	
	
	
	
	
	

