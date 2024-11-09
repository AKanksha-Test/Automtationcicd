  package rahulsheetyacademy.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulsheety.pageobjects.CartPage;

public class AbstractComponent {
	WebDriver driver;
public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
@FindBy(css="[routerlink*='cart']")
WebElement CartHeader;
@FindBy(css="[routerlink*='myorders']")
WebElement orderHeader;


	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitForWebElementToAppear(WebElement findBy)
	{

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));	
	}
	public CartPage goToCartPage()
	{
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		CartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
				return orderpage;
	}
	public void waitForElementToDisappear(WebElement ele)
	{
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
}
