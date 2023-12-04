package com.qnode.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects{
	
	WebDriver driver;	
	
	//objects
	@FindBy(xpath= "//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")
	private  WebElement Myaccount;
	
	@FindBy(xpath= "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private  WebElement Login;
	
	@FindBy(xpath= "//*[@id=\"input-email\"]")
	private  WebElement username;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private  WebElement password;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private  WebElement submit;
	
	public LoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public void clickmyaccount()
	{
		Myaccount.click();
	}
	public void clicklogin()
	{
		Login.click();
	}
	public  void Enterusername()
	{
		username.sendKeys("vinoth123test@gmail.com");
	}
	public  void Enterpassword()
	{
		password.sendKeys("Test@123");
	}
	public  void clickonsubmit()
	{
		submit.click();
	}
	}

/*public static WebElement username(WebDriver driver) {
return driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
}
public static WebElement password(WebDriver driver) {
return driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
}
public static WebElement submit(WebDriver driver) {
return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
}*/
