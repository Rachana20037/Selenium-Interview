package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
	WebDriver driver;

	public PIMPage(WebDriver driver) {

		this.driver = driver;

}
	
	By PIM_Menu = By.xpath("(//span[.=\"PIM\"])[1]"); //PIM Menu
	By AddEmpBtn = By.xpath("//button[.=\" Add \"]"); 	//Add Employee Button
	By FirstName =By.name("firstName");
//	By MiddleName =By.name("middleName");
	By LastName =By.name("lastName");
	By SaveBtn =By.xpath("//button[.=\" Save \"]");
	By page2SaveBtn= By.xpath("(//button[@type=\"submit\"])[1]");
	
	public void clickPIMMenu() {
	    driver.findElement(PIM_Menu).click();
	}

	public void clickAddEmployeeBtn() {
	    driver.findElement(AddEmpBtn).click();
	}
	
	public void enterFirstName(String fName) {
		driver.findElement(FirstName).sendKeys(fName);
	}
	public void enterLastName(String lName) {
		driver.findElement(LastName).sendKeys(lName);
	}
	public void clickSave() {
		driver.findElement(SaveBtn).click();
	}
	
	public void page2SaveBtn() {
		driver.findElement(page2SaveBtn).click();
	}
	
	public void addEmployee(String fName, String lName) {
		enterFirstName(fName);
		enterLastName(lName);
		clickSave();
	}
}
