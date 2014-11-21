package com.framework.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private By noOfMailsLoc = By.xpath("//a[contains(text(),'Inbox')]");
	
	protected WebDriver driver;
	HomePage(WebDriver driver){
		this.driver= driver;
		System.out.println("this is home page");
	}
	public String homePageMethod(){
		System.out.println("This is home page method");
		String noOfMail = driver.findElement(noOfMailsLoc).getText();
		System.out.println(noOfMail);
		return noOfMail;
		//return new HomePage(driver);
	}

}
