/*BaseClass should:

Before Method :
	1.Call DriverFactory
	2.Get Driver
	3.Maximize Browser
	4.Open URL
After Method: Close Browser */


package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import utilities.configReader;
import drivers.DriverFactory;
public class BaseClass {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(configReader.getProperty("url"));
	}
	
	@Test
    public void test() {
        System.out.println("TestNG Working");
    }
	
	@AfterMethod
	public void tearDown() {
//		DriverFactory.quitDriver();
	}
	
	
	
}
