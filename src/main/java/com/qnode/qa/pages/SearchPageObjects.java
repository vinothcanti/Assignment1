package com.qnode.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObjects {

	WebDriver driver;	

	//objects
	@FindBy(xpath= "//*[@name = 'search']")
	private  WebElement Searchkey;

	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private  WebElement Search;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/span")
	private WebElement Addtocart;

	public SearchPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//Actions
	public void searchkey()
	{
		Searchkey.sendKeys("mac");
	}
	public void search()
	{
		Search.click();
	}	
	public void clickaddrocart()
	{
		Addtocart.click();
	}
}
