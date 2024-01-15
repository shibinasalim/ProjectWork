package projectpages1;

import org.openqa.selenium.By;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy (xpath="//input[@placeholder='Email']")
	WebElement email;
	
	@FindBy (xpath="//input[@placeholder='Password']")
	WebElement pswd;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement button;
	
	@FindBy (xpath="//span[text()='Dashboard']")
	WebElement succmsg;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//initialise webelements declared using @findby
	}
	
	public String doLogin(String username,String password)
	{
		
		email.sendKeys(username);
		
		pswd.sendKeys(password);
		
		button.click();
		
		String actualmsg=succmsg.getText();
		return actualmsg;
		
	}

}
