package com.qnode.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(xpath = "//*[@id=\"cart-total\"]")
	private  WebElement addtocart;
	
	@FindBy(xpath="//strong[text()='View Cart']")
	private WebElement viewCartOption;
	
	////*[contains(text(),'Checkout')]
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
	private  WebElement checkoutbutton;
	
	
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public void ClickOnAddtocartBtn()
	{
		addtocart.click();
	}
	public void ClickOnAddtocartBtnincartpage()
	{
		viewCartOption.click();
	}
	public void Clickcheckoutbtn()
	{
		checkoutbutton.click();
	}
}
