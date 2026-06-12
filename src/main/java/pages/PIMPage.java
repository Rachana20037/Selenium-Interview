package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;
import utilities.waitUtils;

public class PIMPage {
	WebDriver driver;
	waitUtils waitUtils;
	CommonMethods commonMethods;
	public PIMPage(WebDriver driver) {

		this.driver = driver;
		waitUtils = new waitUtils(driver);
		commonMethods = new CommonMethods(driver);

}
	
	By PIM_Menu = By.xpath("(//span[.=\"PIM\"])[1]"); //PIM Menu
	By AddEmpBtn = By.xpath("//button[.=\" Add \"]"); 	//Add Employee Button
	By FirstName =By.name("firstName");
//	By MiddleName =By.name("middleName");
	By LastName =By.name("lastName");
	By SaveBtn =By.xpath("//button[@type=\"submit\"]");
	By page2SaveBtn= By.xpath("(//button[@type=\"submit\"])[1]");
	By loader = By.className("oxd-form-loader");
	public void clickPIMMenu() {
//	    driver.findElement(PIM_Menu).click();
	    waitUtils.waitForElementVisible(PIM_Menu).click();
	}

	public void clickAddEmployeeBtn() {
//	    driver.findElement(AddEmpBtn).click();
	    waitUtils.waitForElementVisible(AddEmpBtn).click();
	}
	
	public void enterFirstName(String fName) {
//		driver.findElement(FirstName).sendKeys(fName);
		waitUtils.waitForElementVisible(FirstName).sendKeys(fName);
	}
	public void enterLastName(String lName) {
//		driver.findElement(LastName).sendKeys(lName);
		waitUtils.waitForElementVisible(LastName).sendKeys(lName);
	}
	public void clickSave() {
//		driver.findElement(SaveBtn).click();
		waitUtils.waitForElementVisible(SaveBtn).click();
	}
	
	
	
	public void page2SaveBtn() {
//		scrollToSaveButton();
////		driver.findElement(page2SaveBtn).click();
//		waitUtils.waitForElementVisible(page2SaveBtn).click();
		waitUtils.waitForLoaderToDisappear(loader);
		scrollToSaveButton();
		waitUtils.waitForElementClickable(page2SaveBtn).click();
	}
	public void scrollToSaveButton() {

	    commonMethods.scrollToElement(driver.findElement(page2SaveBtn));
	}
	
	public void addEmployee(String fName, String lName) {
		enterFirstName(fName);
		enterLastName(lName);
		clickSave();
	}
}
