package com.framework.project.classes;
import com.framework.project.util.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {
	protected WebDriver driver;
	ReadFromPropertyFile rfpf= new ReadFromPropertyFile();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException{
		Log.dynamicApp(System.getProperty("user.dir")+"\\src\\test\\resources\\Logs\\","gmail");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String gmailUrl= rfpf.fetchUrl();
		System.out.println("*********"+gmailUrl);
		driver.get(gmailUrl);
		//driver.get("http://www.gmail.com");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
