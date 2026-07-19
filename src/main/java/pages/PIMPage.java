package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
//	Add EMP
	By PIM_Menu = By.xpath("(//span[.=\"PIM\"])[1]"); //PIM Menu
	By AddEmpBtn = By.xpath("//button[.=\" Add \"]"); 	//Add Employee Button
//	By AddEmpBtn = By.xpath("//button[.=\" Add\"]"); 	//Add Employee Button Dummy error Xpath
	By FirstName =By.name("firstName");
//	By MiddleName =By.name("middleName");
	By LastName =By.name("lastName");
	By SaveBtn =By.xpath("//button[@type=\"submit\"]");
	By page2SaveBtn= By.xpath("(//button[@type=\"submit\"])[1]");
	By loader = By.className("oxd-form-loader");
	
//	Search EMP	
	By searchTxt = By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]");
//	By searchTxt = By.className("oxd-autocomplete-text-input oxd-autocomplete-text-input--active");
	By searchEmp = By.xpath("//button[@type=\"submit\"]");	
//	By searchedName =By.xpath("(//div[.=\"bala kumar\"])[2]");
	By searchedName =By.xpath("//button[@type='submit']");
	
//	Delete EMP
	By deleteCheckBox = By.xpath("(//span[contains(@class,'oxd-checkbox-input')])[2]");
	By deleteIcon = By.xpath("(//button[contains(@class,'oxd-icon-button')])[5]");
//	By confirmDelete = By.xpath("(//button[@type=\"button\"])[10]");
	By confirmDelete = By.xpath("//button[.=\" Yes, Delete \"]");
	
	By noRecordFound =By.xpath("//span[text()='No Records Found']");
	
	public void clickPIMMenu() {
//	    driver.findElement(PIM_Menu).click();
	    waitUtils.waitForElementVisible(PIM_Menu).click();
	    waitUtils.waitForLoaderToDisappear(loader);

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
//		driver.findElement(page2SaveBtn).click();
//		waitUtils.waitForElementVisible(page2SaveBtn).click();
		waitUtils.waitForLoaderToDisappear(loader);
		scrollToSaveButton();
		waitUtils.waitForElementClickable(page2SaveBtn).click();
	}
	
	public void scrollToSaveButton() {

	    commonMethods.scrollToElement(driver.findElement(page2SaveBtn));
	}
	
//	public void enterEmployeeName(String empName) {
//		 waitUtils.waitForElementVisible(searchedName).click();
//	}
	public void enterEmployeeName(String empName) {

	    commonMethods.sendKeys(searchTxt, empName);

	}
	public void clickSearch() {
//		 waitUtils.waitForElementVisible(searchEmp).click();
		commonMethods.click(searchEmp);
	}
	/*
	public void searchEmployee(String empName) {
//		waitUtils.waitForElementClickable(sav).click();
//		commonMethods.sendKeys(searchTxt, "bala kumar");
//		driver.findElement(searchTxt).sendKeys("bala kumar");
//		driver.findElement(searchEmp).click();
//		commonMethods.scrollToElement(waitUtils.waitForElementVisible(searchedName));
		
		
		/*commonMethods.sendKeys(searchTxt, empName); 	//Modified search for all emp
		commonMethods.click(searchEmp);*/
		/*enterEmployeeName(empName);
//		selectEmployeeSuggestion(empName);
	    clickSearch();		
		*/
//		commonMethods.sendKeys(searchTxt, empName);
//
//	    commonMethods.click(searchEmp);
//	}*/
	
	public void searchEmployee(String empName) {

	    commonMethods.sendKeys(searchTxt, empName);

	    commonMethods.click(searchEmp);

	    waitUtils.waitForLoaderToDisappear(loader);
	}
	
//	public By getEmployeeNameLocator(String empName) {
//
//	    return By.xpath("(//div[translate(text(), " +	"'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +"'abcdefghijklmnopqrstuvwxyz')='" +empName.toLowerCase() +"'])[2]");
//	}
	/*public boolean isEmployeeDisplayed() {

	    return waitUtils.waitForElementVisible(searchedName).isDisplayed();
	}*/
	public By getEmployeeSuggestion(String empName) {

	    return By.xpath("//div[@role='listbox']//*[contains(text(),'" + empName + "')]");

	}
	public void selectEmployeeSuggestion(String empName) {

		commonMethods.actionClick(getEmployeeSuggestion(empName));

	}
	public boolean isEmployeeDisplayed(String empName) {
//		commonMethods.click(getEmployeeSuggestion(empName));

//	    return waitUtils.waitForElementVisible(getEmployeeNameLocator(empName)).isDisplayed();
		WebElement employee = waitUtils.waitForElementVisible(searchedName);

	    commonMethods.scrollToElement(employee);

	    return employee.isDisplayed();

	}
//	public void scrollToSearchedEmployee(String empName) {
//
//	    WebElement employee =
//	            waitUtils.waitForElementVisible(getEmployeeNameLocator(empName));
//
//	    commonMethods.scrollToElement(employee);
//	}
	public void deleteEmp() {
//		driver.findElement(deleteCheckBox).click();
		commonMethods.click(deleteCheckBox);
//		driver.findElement(deleteIcon).click();
		commonMethods.click(deleteIcon);
//		driver.findElement(confirmDelete).click();
		commonMethods.click(confirmDelete);
	}
	
	public boolean isNoRecordFoundDisplayed() {

	    return waitUtils.waitForElementVisible(noRecordFound).isDisplayed();
	}
	public boolean isPIMpageDisplayed() {
//		return driver.findElement(dashboardTxt).isDisplayed();
	return 	waitUtils.waitForElementVisible(PIM_Menu).isDisplayed();

	}
	
	public void addEmployee(String fName, String lName) {
		enterFirstName(fName);
		enterLastName(lName);
		clickSave();
	}
}
