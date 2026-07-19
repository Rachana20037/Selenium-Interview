package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.PIMPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelUtils;

public class TC_EMP_002_SearchEmployee extends BaseClass {
	@Test
	public void verifySearchEmployee() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	
		
		PIMPage pimPage = new PIMPage(driver);
		
		pimPage.clickPIMMenu();
	
//		Assert.assertTrue(pimPage.isEmployeeDisplayed());
		/*String empName = "Bala Kumar";		//Static search

		pimPage.searchEmployee(empName);

		Assert.assertTrue(pimPage.isEmployeeDisplayed(empName));
		*/
		
//		employee comes from Excel:
		String firstName = ExcelUtils.getCellData("Employees", 1, 0);
		String lastName  = ExcelUtils.getCellData("Employees", 1, 1);

		String empName = firstName + " " + lastName;

		pimPage.searchEmployee(empName);
//		CommonMethods.scrollToElement(empName);
//		pimPage.scrollToSearchedEmployee(empName);

		Assert.assertTrue(pimPage.isEmployeeDisplayed(empName));


	}
}
