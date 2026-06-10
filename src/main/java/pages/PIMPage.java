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
	
	
	public void enterFirstName() {
		driver.findElement(FirstName).sendKeys("Abcc");
	}
	public void enterLastName() {
		driver.findElement(LastName).sendKeys("Deff");
	}
	public void clickSave() {
		driver.findElement(SaveBtn).click();
	}
}
