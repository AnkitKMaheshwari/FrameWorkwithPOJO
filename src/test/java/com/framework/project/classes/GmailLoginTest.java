package com.framework.project.classes;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.project.pages.HomePage;
import com.framework.project.pages.LoginPage;
import com.framework.project.util.ApplicationUtility;
import com.framework.project.util.ReadFromExcelFile;

public class GmailLoginTest extends BaseTestClass{

	/*LoginPage login;
	HomePage home;
	String results="";
	String notes="";
	ReadFromExcelFile rfef = new ReadFromExcelFile();*/
	ApplicationUtility applicationUtility= new ApplicationUtility();
	
	@Test
	public void verifyLoginTest() throws Exception {
		Assert.assertTrue(applicationUtility.launchApplication(driver));
		
		/*login = new LoginPage(driver);
		String[] Login = rfef.getUserName();
		login.enterUsername(Login[0]);
		login.enterpassword(Login[1]);
		System.out.println("++++++++++++++++++"+Login[0]);
		System.out.println("++++++++++++++++++"+Login[1]);
		home=login.clickLoginButton();
		ScreenShots.screenshots(driver);
		try{
		String s1 =home.homePageMethod();
		Log.start("GmailTest");
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
		}*/
}
}

