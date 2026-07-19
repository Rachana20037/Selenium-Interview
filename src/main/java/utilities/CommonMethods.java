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
import org.openqa.selenium.interactions.Actions;

public class CommonMethods {

    WebDriver driver;
    waitUtils waitUtils;

    public CommonMethods(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new waitUtils(driver);

    }

    public void click(By locator) {
//    	  driver.findElement(locator).click(); 		//this before adding waitutiles class
    	
    	 waitUtils.waitForElementClickable(locator).click();

    }

    public void sendKeys(By locator, String text) {
//    	driver.findElement(locator).clear();		// this before adding waitutiles class
//      driver.findElement(locator).sendKeys(text);

    	WebElement element = waitUtils.waitForElementVisible(locator);

        element.clear();

        element.sendKeys(text);
        
    }

    public String getText(By locator) {

//        return driver.findElement(locator).getText();
    	 return waitUtils.waitForElementVisible(locator).getText();

    }

    public void scrollToElement(WebElement element) {

        JavascriptExecutor js =(JavascriptExecutor) driver;
        /* perfectly worked for the big screen size ,true means: Bring element to TOP of page*/
//        js.executeScript("arguments[0].scrollIntoView(true);",element); 
        
        
      //This will work on all screen size , Bring element to CENTER 
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",element); 
    }
    public void actionClick(By locator) {

        Actions actions = new Actions(driver);

        actions.moveToElement(waitUtils.waitForElementVisible(locator))
               .click()
               .perform();
    }
    public void clear(By locator) {

//        driver.findElement(locator).clear(); this before adding waitutiles class
    	  waitUtils.waitForElementVisible(locator).clear();

    }
}
