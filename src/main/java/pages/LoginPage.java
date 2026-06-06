package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By usernameTxt = By.xpath("//input[@placeholder='Username']");
	By passwordTxt = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	
	public void enterUsername(String username) {
		driver.findElement(usernameTxt).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(usernameTxt).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	 public void login(String username, String password) {

	        enterUsername(username);

	        enterPassword(password);

	        clickLogin();

	    }
	
	
}
