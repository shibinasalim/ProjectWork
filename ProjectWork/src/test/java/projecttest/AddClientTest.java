package projecttest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;

import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import projectpages1.ClientPage;
import projectpages1.LoginPage;
import utility.ExcelRead;
import utility.fakerUtility;

public class AddClientTest  extends Basetest{
	
	@Test(priority=1,groups= {"smoke"})
	public void ClientAddition() throws InvalidFormatException, IOException {
		SoftAssert softassert=new SoftAssert();
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		ClientPage ad= new ClientPage(driver);
		String actual=ad.doAddClient("NEBHAN",fakerUtility.phoneNumber(),ExcelRead.getDataFromExcelrow(Constant.excelpath, "Sheet2", 1, 0),"12345","aaaaaa","3");
		String expected="NEBHAN";
		softassert.assertEquals(actual,expected);
	    softassert.assertAll();

	}
	@Test(priority=2,groups= {"smoke"})
	public void ClientSearch() {
		SoftAssert softassert=new SoftAssert();
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		ClientPage ad= new ClientPage(driver);
		ad.clickclient();
		String actual=ad.searchClient("NEBHAN");
		String expected="NEBHAN";
		 softassert.assertEquals(actual,expected);
		 softassert.assertAll();


	}
	@Test(priority=3,groups= {"smoke"})
	public void ClientUpdate() {
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		ClientPage ad= new ClientPage(driver);
		String actual=ad.doUpdateClient("NEBHAN","SHIBINASABINANEBU");
		String expected="SHIBINASABINANEBU";
		Assert.assertEquals(actual,expected);


	}
	@Test(priority=4,groups= {"smoke"})
	public void ClientDelete() {
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		ClientPage ad= new ClientPage(driver);
		String actual=ad.doDeleteClient("SHIBINASABINANEBU");
		String expected="No record found.";
		Assert.assertEquals(actual,expected);


	}

}
