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

import testlink.api.java.client.TestLinkAPIResults;

public class GmailLoginTest extends BaseTestClass{

	LoginPage login;
	HomePage home;
	String results="";
	String notes="";
	ReadFromExcelFile rfef = new ReadFromExcelFile();


	@Test
	public void verifyLoginTest() throws Exception {
		login = new LoginPage(driver);
		String[] Login = rfef.getUserName();
		login.enterUsername(Login[0]);
		login.enterpassword(Login[1]);
		home=login.clickLoginButton();
		ScreenShots.screenshots(driver);
		try{
		String s1 =home.homePageMethod();
		Log.info("===================="+s1);
		Log.info("Login successfull");
		results=TestLinkAPIResults.TEST_PASSED;
		notes="Login was successfull";
		//Assert.assertEquals("Inbox (713)", s1);
	}
		catch(Exception e)
		{
			notes="Login failed";
			results=TestLinkAPIResults.TEST_FAILED;
			//results		
		}
		finally{
			TestLink.reportResult("Gmail", "SampleTest", "FirstLogin", "SampleBuild", notes, results);
		}
}
}

