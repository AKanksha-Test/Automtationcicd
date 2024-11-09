package rahulsheetyacademy.DesignFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver =new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://rahulshettyacademy.com/client");
/*driver.findElement(By.xpath("//a[text()='Register']")).click();
driver.findElement(By.id("firstName")).sendKeys("Akank");
driver.findElement(By.id("lastName")).sendKeys("srivastav");
driver.findElement(By.id("userEmail")).sendKeys("rishabgmail.com");
driver.findElement(By.cssSelector("input[placeholder='enter your number']")).sendKeys("8845634532");
WebElement staticdrpdown=driver.findElement(By.cssSelector("select.custom-select"));
Select dropdown=new Select(staticdrpdown);
dropdown.selectByIndex(1);
driver.findElement(By.cssSelector("input[value='Female']")).click();
driver.findElement(By.id("userPassword")).sendKeys("Akanksha@12");
driver.findElement(By.id("confirmPassword")).sendKeys("Akanksha@12");
driver.findElement(By.xpath("//input[@type='checkbox']")).click();
driver.findElement(By.cssSelector("input[type='Register']")).click();*/
driver.findElement(By.id("userEmail")).sendKeys("rishab@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Akanksha@11");
driver.findElement(By.cssSelector("input[value='Login']")).click();
//List<WebElement> Products=driver.findElements(By.cssSelector(".mb-3 "));
List<WebElement> Products=driver.findElements(By.xpath("//h5/b"));
for(int i=0;i<Products.size();i++)
{
String name=Products.get(i).getText();
if(name.contains("ZARA COAT 3"))
{
	//click on Add to cart
	driver.findElements(By.cssSelector(".btn.w-10.rounded")).get(i).click();
	break;
}
}
	}

}
