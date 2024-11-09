package rahulsheetyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulsheety.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
public WebDriver intializeDriver() throws IOException
{
	/*WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
	Properties prop=new Properties();
	//FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\project\\DesignFramework\\src\\main\\java\\rahulshetyacademy\\resources\\GlobalData.properties");
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src\\main\\java\\rahulshetyacademy\\resources\\GlobalData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
			{
		 driver =new ChromeDriver();
		 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		
			}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		//Firefox
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		 //driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
}
@BeforeMethod(alwaysRun=true)
public LandingPage launchApplication() throws IOException
{
	
	 driver=intializeDriver();
	 landingPage=new LandingPage(driver);
	 landingPage.goTo();
	 return landingPage;
}
@AfterMethod(alwaysRun=true)
public void tearDown()
{
	
	driver.close();
}
}
