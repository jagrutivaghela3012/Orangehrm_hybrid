package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class OHAppUtil {
	WebDriver driver;
	Properties conpro;
	@BeforeSuite
	public void setup()throws Throwable
	{
		conpro=new Properties();
		conpro.load(new FileInputStream("E:\\SELENIUM_TESTING\\Orangehrm_HybridFramework\\PropertyFile\\Environment.properties"));
		if(conpro.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(conpro.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}

}
