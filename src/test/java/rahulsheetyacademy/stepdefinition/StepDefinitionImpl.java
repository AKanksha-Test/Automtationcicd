package rahulsheetyacademy.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulsheety.pageobjects.CartPage;
import rahulsheety.pageobjects.CheckoutPage;
import rahulsheety.pageobjects.ConfirmationPage;
import rahulsheety.pageobjects.LandingPage;
import rahulsheety.pageobjects.productCatalogue;
import rahulsheetyacademy.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public  productCatalogue procat;
	ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage =launchApplication();
}
@Given("^Logged in with username(.+)and password(.+)$")	
public void logged_in_username_and_password(String name,String password )
{
	procat =landingPage.loginApplication(name,password)	;
}  

@When("^I add product(.+) to cart$")
public void I_add_product_to_cart(String productName) 
{
	List<WebElement> Products=procat.getProductList();
	procat.addProductToCart(productName);	
}
//And Checkout<productName> and submit the order
@When("^Checkout(.+)and submit the order$")
public void Checkout_submit_the_order(String productName)
{
	CartPage cartpage=procat.goToCartPage();
	Boolean match=cartpage.BooleanVerifyProductDisplay(productName);
	Assert.assertTrue(match); 
	CheckoutPage checkoutpage=cartpage.goToCheckout();
	
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(0,500)");
	 confirmationPage=checkoutpage.submitOrder();
}
@Then("{string} message is displayed on ConfirmationPage")
public void message_is_displayed_on_ConfirmationPage(String string)
{
	String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
}
//Then "Incorrect email or password" message is displayed
@Then("{string} message is dispalyed")
public void message_is_displayed(String string)
{
	Assert.assertEquals(string,landingPage.getErrorMessage());
	driver.close();
		
}
}

