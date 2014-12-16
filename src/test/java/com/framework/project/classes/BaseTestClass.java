package com.framework.project.classes;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.framework.project.beans.FrameWorkUtilityPOJO;
import com.framework.project.util.FrameWorkUtility;
import com.framework.project.util.Log;
import com.framework.project.util.ReadFromPropertyFile;

public class BaseTestClass {
    WebDriver driver;
	FrameWorkUtility frameWorkUtility = new FrameWorkUtility();
	FrameWorkUtilityPOJO frameWorkUtilityPOJO = new FrameWorkUtilityPOJO();
	ReadFromPropertyFile re = new ReadFromPropertyFile();
	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException{
		
		Log.dynamicApp(System.getProperty("user.dir")+"\\src\\test\\resources\\Logs\\","gmail");

		frameWorkUtilityPOJO = re.getFrameWorkUtility();
		driver=frameWorkUtility.launchBrowser(driver,frameWorkUtilityPOJO.getStrExplorer());
		driver.get(frameWorkUtilityPOJO.getStrAppUrl());
		System.out.println(driver.getCurrentUrl());
	}

	/*@AfterMethod
	public void tearDown(){
	driver.quit();

	}*/
}
