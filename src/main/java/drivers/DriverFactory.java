/* DriverFactory's only job is: 1. Create Browser
2. Return Browser
3. Close Browser
*/

package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;  //(which exposes the field directly),
	
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	//This follows encapsulation, which is a core OOP principle and common in production code.
	public static WebDriver getCurrentDriver() {

	    return driver;

	}
	
	public static void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
		
	}

}