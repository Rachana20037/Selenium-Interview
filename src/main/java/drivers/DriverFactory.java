/* DriverFactory's only job is: 1. Create Browser
2. Return Browser
3. Close Browser
*/

package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
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
}*/

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

//            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {

            throw new IllegalArgumentException("Invalid Browser : " + browser);

        }

        return driver;
    }

    public static WebDriver getCurrentDriver() {

        return driver;

    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();
            driver = null;

        }

    }

}