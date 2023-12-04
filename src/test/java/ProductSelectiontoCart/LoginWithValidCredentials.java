package ProductSelectiontoCart;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.Base;
import com.qnode.qa.pages.LoginPageObjects;
import com.qnode.qa.pages.SearchPageObjects; 
import com.qnode.qa.pages.ShoppingCartPage;

public class LoginWithValidCredentials extends Base {


	LoginPageObjects loginpageobjects;
	ShoppingCartPage shoppingcartpage;
	SearchPageObjects searchpageobjects;


	@Test(priority=1)
	public void loginwithvalidcredentials () throws InterruptedException {

		loginpageobjects = new LoginPageObjects(driver);
		loginpageobjects.clickmyaccount();
		loginpageobjects.clicklogin();
		loginpageobjects.Enterusername();
		loginpageobjects.Enterpassword();
		loginpageobjects.clickonsubmit();	
		Assert.assertEquals(12, 12);

		String positive = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
		if(positive.equals(positive))
		{
			System.out.println("Application logged in successfully");

		}
		else
		{
			System.out.println("Application failed to logged in");
		}
	}

	@Test(priority=2)
	public void search () throws InterruptedException {

		searchpageobjects = new SearchPageObjects(driver);
		searchpageobjects.searchkey();
		searchpageobjects.search();
		String laptopname1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).getText();
		String laptopname2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[1]/h4/a")).getText();
		String laptopname3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[3]/div/div[2]/div[1]/h4/a")).getText();
		String laptopname4 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[4]/div/div[2]/div[1]/h4/a")).getText();
		searchpageobjects.clickaddrocart();
		if(laptopname1.equals(laptopname1))
		{
			System.out.println("Application successfully displayed laptop names" + laptopname1 + " " + laptopname2 + " " + laptopname3 + " " + laptopname4 + " ");
		}

		Thread.sleep(3000);
		WebElement success = driver.findElement(By.cssSelector(".alert-success"));
		String successmessgae = success.getText();
		System.out.println(successmessgae);
	}

	@Test(priority=3)
	public void addtocart () throws InterruptedException
	{
		shoppingcartpage = new ShoppingCartPage(driver);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		shoppingcartpage.ClickOnAddtocartBtn();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(2000);
		String subtotal = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[1]/td[2]")).getText();
		String ecotax = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[2]/td[2]")).getText();
		String vat = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[3]/td[2]")).getText();
		String total = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[4]/td[2]")).getText();
		System.out.println("Subtotal = " + subtotal);
		System.out.println("Eco Tax = " + ecotax);
		System.out.println("Vat = " + vat);
		System.out.println("Total = " + total);
		shoppingcartpage.ClickOnAddtocartBtnincartpage();
		Thread.sleep(2000);
		String Alertmessage = driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")).getText();
		System.out.println(Alertmessage);
		shoppingcartpage.Clickcheckoutbtn();
		Thread.sleep(2000);
	}	
}
