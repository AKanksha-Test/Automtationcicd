package rahulsheety.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulsheetyacademy.Abstractcomponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	/*String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));*/
@FindBy(css=".hero-primary")
WebElement ConfirmationMessage;
public String getconfirmationMessage()
{
	return ConfirmationMessage.getText();
}
}