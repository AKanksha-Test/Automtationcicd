package rahulsheety.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.Abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement userEmail1=driver.findElement(By.id("userEmail"));
		//pagefactory
		@FindBy(id="userEmail")
		WebElement userEmail1;
		//driver.findElement(By.id("userPassword")).sendKeys("Akanksha@11");
		@FindBy(id="userPassword")
		WebElement password;
		//driver.findElement(By.cssSelector("input[value='Login']")).click();
		@FindBy(css=("input[value='Login']")) 
		WebElement submit;
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;


public productCatalogue loginApplication(String Email,String Password)
{
	userEmail1.sendKeys(Email);
	password.sendKeys(Password);
	submit.click();
	productCatalogue procat=new productCatalogue(driver);
	return procat;
	
}
public String getErrorMessage()
{
	waitForWebElementToAppear(errorMessage);
	return errorMessage.getText();
	
}
public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}
}
