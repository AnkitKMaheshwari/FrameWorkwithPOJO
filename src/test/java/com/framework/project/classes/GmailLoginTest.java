package com.framework.project.classes;
import java.util.concurrent.TimeUnit;
import com.framework.project.util.*;
import junit.framework.Assert;
import com.framework.project.pages.*;
import com.framework.project.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailLoginTest extends BaseTestClass{

	LoginPage login;
	HomePage home;
	ReadFromExcelFile rfef = new ReadFromExcelFile();


	@Test
	public void verifyLoginTest() throws Exception {
		login = new LoginPage(driver);
		String[] Login = rfef.getUserName();
		login.enterUsername(Login[0]);
		login.enterpassword(Login[1]);
		home=login.clickLoginButton();
		ScreenShots.screenshots(driver);
		String s1 =home.homePageMethod();
		Log.info("===================="+s1);
		//Assert.assertEquals("Inbox (713)", s1);


	}
}

