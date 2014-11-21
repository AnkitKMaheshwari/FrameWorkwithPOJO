
package com.framework.project.pages;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage{
	private By usernameLoc = By.id("Email");
	private By clickbutton= By.id("signIn");
	private By userpassword= By.id("Passwd");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage enterUsername(String username){
		driver.findElement(usernameLoc).sendKeys(username);
		return new LoginPage(driver);
	}
	public LoginPage enterpassword(String password){
		driver.findElement(userpassword).sendKeys(password);
		return new LoginPage(driver);
	}
	
	public HomePage clickLoginButton(){
	driver.findElement(clickbutton).click();
		return new HomePage(driver);
	}
	
}
