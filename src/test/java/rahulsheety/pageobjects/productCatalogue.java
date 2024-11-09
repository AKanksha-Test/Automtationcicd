package rahulsheety.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulsheetyacademy.Abstractcomponent.AbstractComponent;
public class productCatalogue extends AbstractComponent {
	WebDriver driver;
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//List<WebElement> Products=driver.findElements(By.cssSelector(".mb-3 "));
	@FindBy(css=".mb-3")
List<WebElement>products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
By productsBy=By.cssSelector(".mb-3");
By addToCart=(By.cssSelector(".btn.w-10.rounded"));
By toastMessage=(By.cssSelector("#toast-container"));
public List<WebElement> getProductList()
{
	 waitForElementToAppear(productsBy);
	 return products;
}
public WebElement getProductByName(String ProductName)
{
	//WebElement prod=Products.stream().filter(product->
	//product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	WebElement prod=getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	return prod;
}
public void addProductToCart(String ProductName )
{
//prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
WebElement prod=getProductByName(ProductName);
prod.findElement(addToCart).click();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
waitForElementToAppear(toastMessage);
//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
waitForElementToDisappear(spinner);
}
}