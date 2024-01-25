package projectpages1;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class Estimate {
	WaitUtility waitutil;
	ElementUtility elementutil;
	WebDriver driver;
	@FindBy (xpath="//span[text()='Estimates']")
	WebElement estimate;

	@FindBy (xpath="//span[text()='Estimate List']")
	WebElement estimatelist;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchelt;

	@FindBy (xpath="//a[@title='Add estimate']")
	WebElement addestimate;
	@FindBy (xpath="//input[@placeholder='Estimate date']")
	WebElement estimatedate;
	@FindBy (xpath="//input[@placeholder='Valid until']")
	WebElement validuntil;
	@FindBy (xpath="//div[@id='s2id_estimate_client_id']")
	private WebElement clientdropdown;
	@FindBy(xpath="//input[@id='s2id_autogen9_search']")
	private WebElement clientsearch;
	@FindBy(xpath="//ul[@class='select2-results']//li[1]//div//span")
	private WebElement clientoption;
	@FindBy (xpath="//button[@type='submit']")
	WebElement button_submit;
	@FindBy (xpath="//button[@class='close']")
	WebElement button_close;
	//@FindBy (xpath="//div[@id='page-container']//descendant::h1")
	@FindBy (xpath="//table//tbody//tr[3]//td[3]//div//following-sibling::strong")
	WebElement estimateassertion;
	public Estimate(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitutil=new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
	}


	public String doaddEstimate(String dateestimate,String valid,String SearchClient )
	{
	
		estimate.click();
		waitutil.WaitClickable(estimatelist);
		estimatelist.click();
		waitutil.WaitClickable(addestimate);
		addestimate.click();
		waitutil.WaitVisibilty(estimatedate);
		elementutil.estimatedate(estimatedate,dateestimate);
		waitutil.WaitVisibilty(validuntil);
		elementutil.estimatedate(validuntil,valid);
		clientdropdown.click();
		waitutil.WaitVisibilty(clientsearch);
		clientsearch.sendKeys(SearchClient);
		clientoption.click();
		waitutil.WaitClickable(button_submit);
		button_submit.click();
		waitutil.WaitClickable(button_close);
		button_close.click();
		estimate.click();
		waitutil.WaitVisibilty(estimateassertion);
		String actualmsg=estimateassertion.getText();
		System.out.println(actualmsg);
		return actualmsg;


	}
	/*public String searchestimation(String searchname)
	{

		waitutil.WaitClickable(searchelt);
		searchelt.sendKeys(searchname);
		
		By locator=By.xpath("//table[@id='monthly-estimate-table']//tbody//tr//td[2]//a[contains(text(),'"+searchname+"')]");
		waitutil.WaitVisibilty(locator);
		List<WebElement> estimatetable=driver.findElements(By.xpath("//table[@id='monthly-estimate-table']//tbody//tr//td[2]//a[contains(text(),'"+searchname+"')]"));
		waitutil.WaitVisibility(estimatetable);
		int row=elementutil.getTableDataRowCount(estimatetable, searchname);

		String actualmsg="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='monthly-estimate-table']//tbody//tr["+row+"]//td[2]"));
			actualmsg=tableRow.getText();
			System.out.println("VerifySearch "  +actualmsg);
		}
		return actualmsg;
	}
	public void clickestimate()
	{
		estimate.click();
		waitutil.WaitClickable(estimatelist);
		estimatelist.click();
	}*/
}
