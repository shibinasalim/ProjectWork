package projecttest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import projectpages1.Addclient;
import projectpages1.LoginPage;

public class AddClientTest  extends Basetest{
  @Test(priority=1,groups= {"smoke"})
  public void ClientAddition() {
	  LoginPage lp=new LoginPage(driver);
	 	 lp.doLogin("admin@admin.com","12345678");
	 	 Addclient ad= new Addclient(driver);
	 	 String actual=ad.doAddClient("NEBHAN","1234","london","12345","aaaaaa","3");
	 	 String expected="NEBHAN";
	 	  Assert.assertEquals(actual,expected);

	 	 
  }
  @Test(priority=2,groups= {"smoke"})
  public void ClientSearch() {
	  LoginPage lp=new LoginPage(driver);
	 	 lp.doLogin("admin@admin.com","12345678");
	 	 Addclient ad= new Addclient(driver);
	 	 ad.clickclient();
	 	 String actual=ad.searchClient("NEBHAN");
	 	 String expected="NEBHAN";
	 	  Assert.assertEquals(actual,expected);

	 	 
  }
  @Test(priority=3,groups= {"smoke"})
  public void ClientUpdate() {
	  LoginPage lp=new LoginPage(driver);
	 	 lp.doLogin("admin@admin.com","12345678");
	 	 Addclient ad= new Addclient(driver);
	 	 String actual=ad.doUpdateClient("NEBHAN","SHIBINASABINANEBU");
	 	 String expected="SHIBINASABINANEBU";
	 	  Assert.assertEquals(actual,expected);

	 	 
  }
  @Test(priority=4,groups= {"smoke"})
  public void ClientDelete() {
	  LoginPage lp=new LoginPage(driver);
	 	 lp.doLogin("admin@admin.com","12345678");
	 	 Addclient ad= new Addclient(driver);
	 	 String actual=ad.doDeleteClient("SHIBINASABINANEBU");
	 	 String expected="No record found.";
	 	  Assert.assertEquals(actual,expected);

	 	 
  }
  
}
