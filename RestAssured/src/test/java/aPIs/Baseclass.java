package aPIs;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	WebDriver driver;
	

	
@BeforeClass	
public void launchbrowser() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\RestAssured\\Browser\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}




@AfterClass
public void closebrowser()
{
	driver.quit();
}
}
