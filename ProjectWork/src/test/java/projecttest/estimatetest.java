package projecttest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import projectpages1.Estimate;
import projectpages1.LoginPage;

import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class estimatetest extends  Basetest{
  @Test(priority=1,groups= {"smoke"})
  public void estimate() {
	 LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		Estimate es=new Estimate(driver);
		String actual=es.doaddEstimate("2024-01-25","2024-02-10","Sabina");
		String expected="Sabina";
		Assert.assertEquals(actual,expected);
		
  }
}
 /* @Test(priority=2,groups= {"smoke"})
  public void estimateSearc() {
	  LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		Estimate es=new Estimate(driver);
		es.clickestimate();
		String actual=es.searchestimation("Sabina");
		String expected="Sabina";
		Assert.assertEquals(actual,expected);
		
  }*/

