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
import org.testng.annotations.Test;

import rahulsheety.pageobjects.CartPage;
import rahulsheety.pageobjects.CheckoutPage;
import rahulsheety.pageobjects.ConfirmationPage;
import rahulsheety.pageobjects.LandingPage;
import rahulsheety.pageobjects.productCatalogue;
import rahulsheetyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {
	 
	public void StandAlone() throws IOException {
		
		// TODO Auto-generated method stub
		String productName= "ZARA COAT 3";
		landingPage.loginApplication("rishab@gmail.com","Akanksha@11");
		Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
		
		
		
	
	
	}

}


