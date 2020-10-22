package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;

public class Test9 {
  
	private Properties properties;
	private final String propertyFilePath= "SelRestAssured//config.properties";
	 
	 
	 public Test9(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getcred(){
	 String cred = properties.getProperty("Credentials");
	 if(cred!= null) return cred;
	 else throw new RuntimeException("Credentials not specified in the config.properties file."); 
	 }
	 
	 public String getBrowserName() { 
	 String browserName = properties.getProperty("BrowserName");
	 if(browserName != null) return browserName;
	 else throw new RuntimeException("Browser Name not specified in the config.properties file."); 
	 }
	 
	 public String getApplicationUrl() {
	 String url = properties.getProperty("URL");
	 if(url != null) return url;
	 else throw new RuntimeException("url not specified in the config.properties file.");
	 }

  

}
