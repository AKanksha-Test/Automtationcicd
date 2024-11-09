package rahulsheety.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.Abstractcomponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	@FindBy(css=".action__submit")
	WebElement submit;
	//By.cssSelector(".ta-results")));
	By results=By.cssSelector(".ta-results");
/*a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();*/
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		/*a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();*/
		a.sendKeys(Country,countryName).build().perform();
		
		/*//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));*/
		 waitForElementToAppear(results);
		//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		 selectCountry.click();
		
	}
	public ConfirmationPage submitOrder()
	{
		//driver.findElement(By.cssSelector(".action__submit")).click();
		submit.click();
		return new ConfirmationPage(driver);
	}
}
