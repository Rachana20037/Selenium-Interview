package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
	 WebDriver driver;

	    public CommonMethods(WebDriver driver) {

	        this.driver = driver;

	    }

	    public void scrollToElement(WebElement element) {

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript( "arguments[0].scrollIntoView(true);", element);

	    }
}
