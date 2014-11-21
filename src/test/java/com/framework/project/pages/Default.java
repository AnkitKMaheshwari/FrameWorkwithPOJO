package com.framework.project.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Default {
	
	
	public WebDriver driver;
	public WebDriver launch() throws Exception{
		System.out.println("I am in launch method");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.gmail.com");
		return driver;
		//Thread.sleep(2000);
	}
	
	
	public void close(){
		System.out.println("reaached at close method");
		driver.quit();
	}
	
	


}
