package com.framework.project.util;

import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.framework.project.util.Log;



public class ScreenShots {
	
	public static void screenshots(WebDriver driver) throws IOException{
		  
		DateFormat format=new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		Date d=new Date();
		String date=format.format(d);
		Log.info("Screenshotdate with modified date="+date);
		Log.info("//src//test//resources//Screenshots//login"+date+".png");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//test//resources//Screenshots//login_"+date+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 }

}
