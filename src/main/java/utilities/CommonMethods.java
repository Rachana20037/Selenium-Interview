/*
sendKeys()
click()
scroll()
 */


package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
	WebDriver driver;

    public CommonMethods(WebDriver driver) {

        this.driver = driver;

    }

    public void click(By locator) {

        driver.findElement(locator).click();

    }

    public void sendKeys(By locator, String text) {

        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        
    }

    public String getText(By locator) {

        return driver.findElement(locator).getText();

    }

    public void scrollToElement(WebElement element) {

        JavascriptExecutor js =(JavascriptExecutor) driver;
        /* perfectly worked for the big screen size ,true means: Bring element to TOP of page*/
//        js.executeScript("arguments[0].scrollIntoView(true);",element); 
        
        
      //This will work on all screen size , Bring element to CENTER 
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",element); 
    }
    
    public void clear(By locator) {

        driver.findElement(locator).clear();

    }
}
