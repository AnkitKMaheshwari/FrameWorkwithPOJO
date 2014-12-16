package com.framework.project.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class FrameWorkUtility {
	WebDriver driver;
	ReadFromPropertyFile rfpf1= new ReadFromPropertyFile();
	
	public WebDriver launchBrowser(WebDriver driver,String explorer) throws FileNotFoundException, IOException
	 {
	
	 	  if(explorer.equalsIgnoreCase("chrome"))
	  {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\exefiles\\chromedriver.exe");
	        driver=new ChromeDriver();
	  }
	  else
	  {
	  if(explorer.equalsIgnoreCase("IE"))
	  {
	     System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\exefiles\\IEDriverServer.exe" );
	     System.out.println( System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\exefiles\\IEDriverServer.exe" ));
	     driver = new InternetExplorerDriver();
	  }
	  else
	  {
		  
	  driver=new FirefoxDriver();
	  
		  }
	  
		  
	  }
	 	 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		return driver;
	  }
		

	
	/*public void close(WebDriver driver){
		this.driver=driver;
		 driver.quit();
	 }*/
}
