package com.framework.project.util;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.framework.project.beans.FrameWorkUtilityPOJO;
import com.framework.project.beans.LoginPOJO;
import com.framework.project.beans.TestLinkPOJO;

public class ReadFromPropertyFile {
	Properties properties = new Properties();
	FrameWorkUtilityPOJO frameWorkUtilityPOJO;
	LoginPOJO loginPOJO;

	public Properties read() throws FileNotFoundException, IOException{
		
		Log.info("in try block");
		properties.load(new FileInputStream("src/test/resources/Data/Config.properties"));
		System.out.println("File read");
		return properties;
	}
	
	public FrameWorkUtilityPOJO getFrameWorkUtility() throws FileNotFoundException, IOException{
		properties = this.read();
		frameWorkUtilityPOJO = new FrameWorkUtilityPOJO();
		System.out.println("____________"+properties.getProperty("browser"));
		frameWorkUtilityPOJO.setStrExplorer(properties.getProperty("browser"));
		System.out.println("____________"+properties.getProperty("application"));
		frameWorkUtilityPOJO.setStrAppUrl(properties.getProperty("application"));
		System.out.println("UUUUUUUUUU"+properties.getProperty("username"));
		return frameWorkUtilityPOJO;
	}
	public LoginPOJO getLoginDeatils() throws FileNotFoundException, IOException{
		properties = this.read();
		loginPOJO = new LoginPOJO();
		System.out.println("UUUUUUUUUU"+properties.getProperty("application"));
		loginPOJO.setStrUserName(properties.getProperty("username"));
		
		loginPOJO.setStrPassword(properties.getProperty("password"));
		return loginPOJO;
	}
	public TestLinkPOJO getTestLinkPOJO() throws FileNotFoundException, IOException{
		properties=this.read();
		TestLinkPOJO testLinkPOJO =new TestLinkPOJO();
		testLinkPOJO.setStrTestProject(properties.getProperty("testProject"));
		testLinkPOJO.setStrTestPlan(properties.getProperty("testPlan"));
		testLinkPOJO.setStrTestCase(properties.getProperty("testCase"));
		testLinkPOJO.setStrBuild(properties.getProperty("build"));
		return testLinkPOJO;
	}
	
	
	
}
