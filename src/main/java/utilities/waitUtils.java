/*
Wait for element
Wait for text
Wait for loader
Wait for clickable
 */

package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtils {
	WebDriver driver;
	WebDriverWait wait;

	public waitUtils(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public WebElement waitForElementVisible(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement waitForElementClickable(By locator) {

		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void waitForLoaderToDisappear(By loader) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}

	public boolean isElementDisplayed(By locator) {

		return waitForElementVisible(locator).isDisplayed();

	}

	public boolean isElementEnabled(By locator) {

		return waitForElementVisible(locator).isEnabled();

	}

	public boolean isElementSelected(By locator) {

		return waitForElementVisible(locator).isSelected(); // Used for : Checkbox ->Radio Button

	}

	public boolean waitForURLContains(String urlPart) {

		return wait.until(ExpectedConditions.urlContains(urlPart));

	}

	public boolean waitForTitleContains(String title) {

		return wait.until(ExpectedConditions.titleContains(title)); // Used after navigation.

	}

	public void waitForAlert() {

		wait.until(ExpectedConditions.alertIsPresent()); // useful for : Delete Confirmation -> Browser Alert

	}

	public void waitForFrame(By locator) {

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)); // Useful for iframe applications.

	}

	public void waitForTextToBePresent(By locator, String text) {
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text)); // Used for : Success, Failed , etc

	}

	public void waitForElementInvisible(By locator) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)); //Useful for : Loader,spinner , toast

	}
	public void waitForPageLoad() {

	    wait.until(driver ->((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

	}
}
