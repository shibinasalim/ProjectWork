package projectpages1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtility;
import utility.WaitUtility;

public class Addclient {
	WaitUtility waitutil;
	ElementUtility elementutil;
	WebDriver driver;
	
	@FindBy (xpath="//span[text()='Clients']")
	WebElement clients;
	
	@FindBy (xpath="//a[@title='Add client']")
	WebElement addclient;
	
	@FindBy (xpath="//input[@placeholder='Company name']")
	WebElement companyname;
	
	@FindBy (xpath="//input[@name='zip']")
	WebElement zipcode;
	
	@FindBy (xpath="//input[@name='country']")
	WebElement country_region;
	
	@FindBy (xpath="//input[@name='phone']")
	WebElement phone_number;
	
	@FindBy (xpath="//input[@name='website']")
	WebElement website_add;
	
	@FindBy (xpath="//input[@name='vat_number']")
	WebElement vat_no;
	
	@FindBy (xpath="//input[@name='disable_online_payment']")
	WebElement tick;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement button_submit;
	
	@FindBy (xpath="//button[@class='close']")
	WebElement button_close;
	
	@FindBy (xpath="//input[@placeholder='Search']")
	WebElement searchelt;
	
	@FindBy (xpath="//table[@id= 'client-table']//tbody//tr[1]//td[2]//a")
	WebElement succmsg;
	@FindBy (xpath="//table[@id= 'client-table']//tbody//tr[1]//td[9]//a[1]")
	WebElement update;
	
	@FindBy (xpath="//table[@id= 'client-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement delete;
	
	@FindBy (xpath="//button[@class='btn btn-danger']")
	WebElement confirm_delete;

	@FindBy (xpath="//table[@id= 'client-table']//tbody//tr[1]//td[1]")
	WebElement notfound;

	@FindBy (xpath="//button[@class='close']")
	WebElement close_delete;
	
	

	public Addclient(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitutil=new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
	}
	
	public String doAddClient(String company,String zip,String country,String phone,String website,String vat)
	{
		  clients.click();
		  
		  
		  addclient.click();
	
	   waitutil.WaitVisibilty(companyname);
	  companyname.sendKeys(company);
	  
	  zipcode.sendKeys(zip);
	country_region.sendKeys(country);
	 phone_number.sendKeys(phone);
	 elementutil.scrollselect(website_add);
	 website_add.sendKeys(website);
	 
	 vat_no.sendKeys(vat);
	 
		tick.click();
				button_submit.click();
				button_close.click();
		clients.click();
	

		String actualmsg=searchClient(company);
				return actualmsg;
	}
	public String doUpdateClient(String search,String newvalue)
	{
		clients.click();
		searchelt.sendKeys(search);
		update.click();
		 waitutil.WaitVisibilty(companyname);  
		companyname.clear();
		companyname.sendKeys(newvalue);
		button_submit.click();
		button_close.click();
		clients.click();
		String actual=searchClient(newvalue);
		return actual;
	}
	
	public String doDeleteClient(String search)
	{
		clients.click();
		searchelt.sendKeys(search);
		 waitutil.WaitClickable(delete);
		delete.click();
		 waitutil.WaitClickable(confirm_delete);
		confirm_delete.click();
		 waitutil.WaitClickable(close_delete);
		close_delete.click();
		clients.click();
		searchelt.sendKeys(search);
		String actual=notfound.getText();
		return actual;
	}
	public String searchClient(String searchname)
	{

		
		waitutil.WaitClickable(searchelt);
		searchelt.sendKeys(searchname);

		By locator=By.xpath("//table[@id='client-table']//tbody//tr//td//a[contains(text(),'"+searchname+"')]");
		waitutil.WaitVisibilty(locator);
		List<WebElement> clienttable=driver.findElements(By.xpath("//table[@id='client-table']//tbody//tr//td//a[contains(text(),'"+searchname+"')]"));
		waitutil.WaitClickable(clienttable);
         int row=elementutil.getTableDataRowCount(clienttable, searchname);

		String actualmsg="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr["+row+"]//td[2]"));
			actualmsg=tableRow.getText();
			System.out.println("VerifySearch "  +actualmsg);
		}
		return actualmsg;
	}
	public void clickclient()
	{
		clients.click();
	}
	
}
