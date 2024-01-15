package projecttest;
import java.util.*;
import org.testng.annotations.Test;

import constant.Constant;
import utility.ElementUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Basetest {
	WebDriver driver;
@Parameters({"browser"})
  @BeforeMethod (alwaysRun = true)
//Is used when we want to make sure this always runs even if parameters on which this depends fails
  public void beforeTest(@Optional ("chrome") String browser) throws IOException {
		 
	  	 if(browser.equalsIgnoreCase("chrome"))
	 {
			 driver =new ChromeDriver();
				
				
	  }
	  else if(browser.equalsIgnoreCase("edge"))
	  {
			 driver =new EdgeDriver();
				
				
	  }
	 driver.manage().window().maximize();
	 
		driver.get(ElementUtility.readPropertiesFile("url"));
}

  

  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException 
  {
	 
		  if(ITestResult.FAILURE==result.getStatus())
		  {
			 
		            captureScreenshot(result.getMethod().getMethodName());
		        
		    }
			  
		//  driver.quit();  
  }	  
  public void captureScreenshot(String method_name) {		  
			  try{
								
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new java.util.Date());
				
					File src=screenshot.getScreenshotAs(OutputType.FILE);
				
						String path=Constant.screenshotpath+method_name+dateName+".png";
					File desfile=new File(path);
					FileUtils.copyFile(src,desfile);
					System.out.println("Successfully captured a screenshot");
				
				}catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
				
		  }
	  }
		 
  }

