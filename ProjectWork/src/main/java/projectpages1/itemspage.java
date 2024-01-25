package projectpages1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtility;
import utility.WaitUtility;

public class itemspage {
	WaitUtility waitutil;
	ElementUtility elementutil;


	WebDriver driver;

	@FindBy (xpath="//span[text()='Items']")
	WebElement items;


	@FindBy (xpath="//a[@title='Add item']")
	WebElement additems;


	@FindBy (xpath="//input[@name='title']")
	WebElement title;

	@FindBy (xpath="//input[@name='unit_type']")
	WebElement unit;

	@FindBy (xpath="//input[@name='item_rate']")
	WebElement rate;

	@FindBy (xpath="//button[@type='submit']")
	WebElement button_save;

	@FindBy (xpath="//button[@class='close']")
	WebElement button_close;


	@FindBy (xpath="//input[@placeholder='Search']")
	WebElement searchelt;


	@FindBy (xpath="//table[@id='item-table']//tbody//tr//td[1]")
	WebElement eltlocate;

	@FindBy (xpath="//table[@id='item-table']//tbody//tr[1]//td[5]//a[1]")
	WebElement update;


	@FindBy (xpath="//table[@id='item-table']//tbody//tr[1]//td[5]//a[2]")
	WebElement delete;

	@FindBy (xpath="//button[@class='close']")
	WebElement close_delete;



	@FindBy (xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
	WebElement notfound;

	public itemspage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitutil=new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
	}

	public String doaddItems(String head,String unittype,String itemrate)
	{
		items.click();

		additems.click();
		waitutil.WaitVisibilty(title);


		title.sendKeys(head);



		unit.sendKeys(unittype);
		rate.sendKeys(itemrate);
		waitutil.WaitClickable(button_save);		   
		button_save.click();
		waitutil.WaitClickable(button_close);
		button_close.click();

		items.click();
		
		String actualmsg=searchItem(head);
		System.out.println(actualmsg);

		return actualmsg;

	}
	public String searchItem(String searchname)
	{


	waitutil.WaitClickable(searchelt);
	searchelt.sendKeys(searchname);

	By locator=By.xpath("//table[@id='item-table']//tbody//tr//td[contains(text(),'"+searchname+"')]");
	waitutil.WaitVisibilty(locator);
	List<WebElement> itemtable=driver.findElements(By.xpath("//table[@id='item-table']//tbody//tr//td[1]"));
	waitutil.WaitVisibility(itemtable);
	int row=elementutil.getTableDataRowCount(itemtable, searchname);
	String actualmsg="";

	if(row!=0)
	{
	WebElement tableRow=driver.findElement(By.xpath("//table[@id='item-table']//tbody//tr["+row+"]//td[1]"));
	actualmsg=tableRow.getText();
	System.out.println("Verify SearchItem : " +actualmsg);
	}
	return actualmsg;
	}
	public String doUpdateItem(String search,String newvalue)
	{
		items.click();
		searchelt.sendKeys(search);
		waitutil.WaitVisibilty(update);
		update.click();
		waitutil.WaitVisibilty(title);
		title.clear();
		title.sendKeys(newvalue);
		waitutil.WaitClickable(button_save);
		button_save.click();

		button_close.click();
		items.click();
	
		String actual=searchItem(newvalue);
		System.out.println(actual);

		return actual;
	}
	public String doDeleteItem(String search)
	{
		items.click();
		searchelt.sendKeys(search);
		delete.click();
		waitutil.WaitClickable(close_delete);
		close_delete.click();
		items.click();
		searchelt.sendKeys(search);
		String actual=notfound.getText();
		return actual;
	}
	public void clickItem()
	{
		items.click();
	}

}