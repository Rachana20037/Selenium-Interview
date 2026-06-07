package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {

		this.driver = driver;

	}

	By dashboardTxt = By.xpath("//h6[.='Dashboard']");
	By profileClick = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	By logoutBtn = By.xpath("//a[.='Logout']");

	public boolean isDashboardDisplayed() {
		return driver.findElement(dashboardTxt).isDisplayed();

	}

	public void profileClick() {
		driver.findElement(profileClick).click();
	}

	public void logoutBtn() {
		driver.findElement(logoutBtn).click();
	}
}
