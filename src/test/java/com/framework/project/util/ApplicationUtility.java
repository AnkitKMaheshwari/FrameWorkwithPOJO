package com.framework.project.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import com.framework.project.beans.FrameWorkUtilityPOJO;
import com.framework.project.beans.LoginPOJO;
import com.framework.project.beans.TestLinkPOJO;
import com.framework.project.pages.LoginPage;
import com.framework.project.util.ScreenShots;

public class ApplicationUtility  {
	WebDriver driver;
	
	LoginPOJO loginPOJO=new LoginPOJO();
	
	
	 public boolean launchApplication(WebDriver driver) throws FileNotFoundException, IOException, TestLinkAPIException{
		 this.driver=driver;
		 LoginPage loginPage= new LoginPage(driver);
		 String notes="",results="",value="",date= "";
		 Date d = new Date();
		 boolean flag=true;
		 FrameWorkUtilityPOJO frameWorkUtilityPOJO= new FrameWorkUtilityPOJO();
		 ReadFromPropertyFile readFromPropertyFile= new ReadFromPropertyFile();
		 try{
			loginPOJO=readFromPropertyFile.getLoginDeatils();
			System.out.println("set values");
			loginPage.enterUsername(loginPOJO,driver);
			loginPage.enterpassword(loginPOJO, driver);
			loginPage.clickLoginButton(driver);
			ScreenShots.screenshots(driver);
			Log.info("values enetered");
			DateFormat format=new SimpleDateFormat(" z dd-MM-yyyy hh:mm:ss");
			date= format.format(d);
			Log.info("d");
			
			Log.info("Login Succefull");
			ScreenShots.screenshots(driver);
			results = TestLinkAPIResults.TEST_PASSED;
			Log.info("results updated in try block");
			notes="Successfully executed on "+frameWorkUtilityPOJO.getStrExplorer()+" at " +date; //updating notes section in testlink
			Log.info("notes updated in try block");
			Log.info("TestCase Passed in try block");
			value="Passed"; //value to be written in Excel
		 }
		 catch(Exception e){
			 frameWorkUtilityPOJO = readFromPropertyFile.getFrameWorkUtility();
			 results = TestLinkAPIResults.TEST_FAILED;
			 Log.info("result updated in try block");
			 notes="Execution failed on "+frameWorkUtilityPOJO.getStrExplorer()+" at " +date +"\n" +e; //updating notes section in testlink
				Log.info("notes updated in catch block");
				//Log.("TestCase Failed in catch block");
				value="Failed"; // value to written in Excel
				flag=false;
		 }
	  
		 finally{
			 loginPOJO  = null;
			 loginPage=null;
			 TestLinkPOJO testLinkPOJO =readFromPropertyFile.getTestLinkPOJO();
			 final String ApiKey = "965c4353a34a04aa2971ffa45cdddf6a";
			 final String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
			 readFromPropertyFile.read();
			 TestLinkAPIClient api = new TestLinkAPIClient(ApiKey,url);
			 System.out.println(readFromPropertyFile.getTestLinkPOJO().getStrTestProject()+readFromPropertyFile.getTestLinkPOJO().getStrTestPlan()+readFromPropertyFile.getTestLinkPOJO().getStrTestCase()+readFromPropertyFile.getTestLinkPOJO().getStrBuild());
			// api.reportTestCaseResult(testLinkPOJO.getStrTestProject(), testLinkPOJO.getStrTestPlan(), testLinkPOJO.getStrTestCase(), testLinkPOJO.getStrBuild(),notes,results);
			 //api.reportTestCaseResult(testLinkPOJO.getStrTestProject(),testLinkPOJO.getStrTestPlan(),testLinkPOJO.getStrTestCase(),testLinkPOJO.getStrBuild(),notes,results);
			 api.reportTestCaseResult(testLinkPOJO.getStrTestProject(),testLinkPOJO.getStrTestPlan(),testLinkPOJO.getStrTestCase(),testLinkPOJO.getStrBuild(),notes,results);
		 }
	  
	  return flag;
	
}
}
