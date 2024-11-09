package rahulsheetyacademy.DesignFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulsheety.pageobjects.CartPage;
import rahulsheety.pageobjects.CheckoutPage;
import rahulsheety.pageobjects.ConfirmationPage;
import rahulsheety.pageobjects.LandingPage;
import rahulsheety.pageobjects.productCatalogue;
import rahulsheetyacademy.Abstractcomponent.OrderPage;
import rahulsheetyacademy.TestComponents.BaseTest;

public class StandAloneP extends BaseTest {
	String productName= "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void StandAlone(String email,String Password,String productNmame) throws IOException {
		
		// TODO Auto-generated method stub
		
		productCatalogue procat=landingPage.loginApplication(email,Password);
		List<WebElement> Products=procat.getProductList();
		procat.addProductToCart(productName);
		CartPage cartpage=procat.goToCartPage();
		Boolean match=cartpage.BooleanVerifyProductDisplay(productName);
		Assert.assertTrue(match); 
		CheckoutPage checkoutpage=cartpage.goToCheckout();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutpage.submitOrder();
		confirmationPage.getconfirmationMessage();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		//To verify ZARA COAT 3 is displaying in order page
	}
	@Test(dependsOnMethods= {"StandAloneP"})
	public void orderHistoryTest()
	{
 productCatalogue procat=landingPage.loginApplication("rishab@gmail.com","Akanksha@11");	
 OrderPage orderpage=procat.goToOrderPage();
 Assert.assertTrue(orderpage.BooleanVerifyOrderDisplay(productName));
		
	
	}
@DataProvider()
public Object[][] getData()
{
return new Object[][] {{"rishab@gmail.com","Akanksha@11","ZARA COAT 3"},{"rishabi@gmail.com","Akanksha@1111","ADIDAS ORIGINAL"}};
}

}


