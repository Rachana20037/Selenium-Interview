package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.PIMPage;
import utilities.ConfigReader;

public class TC_EMP_003_DeleteEmployee extends BaseClass {
	@Test
	public void verifyDeleteEmployee() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(5000);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		
		Thread.sleep(5000);
		PIMPage pimPage = new PIMPage(driver);
		Thread.sleep(2000);
		pimPage.clickPIMMenu();
	    pimPage.searchEmployee();
	    pimPage.deleteEmp();
	}
	 
}
