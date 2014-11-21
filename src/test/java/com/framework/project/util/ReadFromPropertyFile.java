package com.framework.project.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadFromPropertyFile {

	public String fetchUrl() throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		Log.info("in try block");
		prop.load(new FileInputStream("src/test/resources/Data/First.properties"));
		System.out.println("File read");
		String url = prop.getProperty("Url");
		System.out.println("))))))))))))))))))))))))"+url);
		return url;
	}
}
