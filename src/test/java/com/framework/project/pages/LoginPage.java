
package com.framework.project.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.project.beans.LoginPOJO;
import com.framework.project.util.ReadFromPropertyFile;

public class LoginPage{
	private By usernameLoc = By.id("Email");
	private By clickbutton= By.id("signIn");
	private By userpassword= By.id("Passwd");
	//LoginPOJO loginPOJO = new LoginPOJO();
	WebDriver driver;
	ReadFromPropertyFile readFromPropertyFile  = new ReadFromPropertyFile();
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}


	public LoginPage enterUsername(LoginPOJO loginPOJO, WebDriver driver){
		//loginPOJO= readFromPropertyFile.getLoginDeatils();
		
		System.out.println("((((((((((((((((((((((((");
		driver.findElement(usernameLoc).sendKeys(loginPOJO.getStrUserName());
		return new LoginPage(driver);
	}
	public LoginPage enterpassword(LoginPOJO loginPOJO,WebDriver driver){
		driver.findElement(userpassword).sendKeys(loginPOJO.getStrPassword());
		return new LoginPage(driver);
	}
	
	public HomePage clickLoginButton(WebDriver driver){
	driver.findElement(clickbutton).click();
		return new HomePage(driver);
	}
	
}
