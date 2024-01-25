package projecttest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import projectpages1.ClientPage;
import projectpages1.LoginPage;
import projectpages1.itemspage;

public class itemtest extends Basetest{
	@Test(priority=1 ,groups= {"regression"})
	public void additem() {
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		itemspage ad= new itemspage(driver);
		String actual=ad.doaddItems("amina","12","20");
		String expected="amina";
		Assert.assertEquals(actual,expected);
	}
	@Test(priority=2 ,groups= {"regression"})
	public void searchitem() {
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		itemspage ad= new itemspage(driver);
		ad.clickItem();
		String actual=ad.searchItem("amina");
		String expected="amina";
		Assert.assertEquals(actual,expected);
	}

	@Test(priority=3,groups= {"regression"},retryAnalyzer = generaltests.Retry.class)
	public void UpdateItem() {
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		itemspage ad= new itemspage(driver);
		String actual=ad.doUpdateItem("shibinshibina","amina");
		String expected="amina";
		Assert.assertEquals(actual,expected);
	}

	@Test(priority=4,groups= {"regression"})
	public void DeleteItem() {
		LoginPage lp=new LoginPage(driver);
		lp.doLogin("admin@admin.com","12345678");
		itemspage ad= new itemspage(driver);
		String actual=ad.doDeleteItem("shibinshibina");
		String expected="No record found.";
		Assert.assertEquals(actual,expected);
	}
}