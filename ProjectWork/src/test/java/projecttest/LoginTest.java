package projecttest;
import org.testng.annotations.Test;

import constant.Constant;

import org.testng.AssertJUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import projectpages1.LoginPage;
import utility.ExcelRead;
public class LoginTest extends Basetest{
  @Test(dataProvider = "dp")
  public void verifyLogin(String username,String password) {
	LoginPage lp=new LoginPage(driver);
	 	 String actual= lp.doLogin(username,password);
	 	  String expectmsg="Dashboard";
	 	  AssertJUnit.assertEquals(actual,expectmsg);
	  }
  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException {
	 Object [][] data=ExcelRead.getDataFromExcel(Constant.excelpath, 
				"Sheet1");
	 return data;
	 
  }

  }

