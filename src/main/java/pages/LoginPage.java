package pages;
import utilities.CommonMethods;
import utilities.waitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

	WebDriver driver;
	WebElement element;
	waitUtils waitUtils;
	CommonMethods commonMethods;
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	    waitUtils = new waitUtils(driver);

	    commonMethods = new CommonMethods(driver);
	}
	
	By usernameTxt = By.name("username");
	By passwordTxt = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	
	public void enterUsername(String username) {
//		driver.findElement(usernameTxt).sendKeys(username); //Method 1
		waitUtils.waitForElementVisible(usernameTxt).sendKeys(username);  //Method 2
		
		/* Sometimes automation runs twice and field contains old value. */
//		element.clear();
//	    element.sendKeys(username);
	}
	
	public void enterPassword(String password) {
//		driver.findElement(passwordTxt).sendKeys(password);
		waitUtils.waitForElementVisible(passwordTxt).sendKeys(password);
		/* Sometimes automation runs twice and field contains old value. */
//		element.clear();
//	    element.sendKeys(password);
	}
	
	public void clickLogin() {
//		driver.findElement(loginBtn).click();
		waitUtils.waitForElementClickable(loginBtn).click();
	}
	public boolean isLoginPageDisplayed() {

	    return waitUtils.waitForElementVisible(usernameTxt).isDisplayed();

	}
	 public void login(String username, String password) {

	        enterUsername(username);

	        enterPassword(password);

	        clickLogin();

	    }
	
	
}
