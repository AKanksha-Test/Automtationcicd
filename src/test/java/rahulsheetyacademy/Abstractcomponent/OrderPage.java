package rahulsheetyacademy.Abstractcomponent;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheety.pageobjects.CheckoutPage;

public class OrderPage extends AbstractComponent{
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;

public Boolean BooleanVerifyOrderDisplay(String productName)
{
	//Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	//Assert.assertTrue(match); 
	Boolean match=productNames.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	return match;
}
public CheckoutPage goToCheckout()
{
	checkoutEle.click();
	return new CheckoutPage(driver);
	
}
}

