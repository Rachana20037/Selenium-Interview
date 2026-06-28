package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.TestDataProvider;
import pages.LoginPage;
import pages.PIMPage;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import testcases.ExcelReadTest;

public class TC_EMP_001_AddEmployee extends BaseClass {

	/*
	 * @Test
	 * 
	 * public void verifyAddEmployee() throws InterruptedException { 
	 * LoginPage loginPage = new LoginPage(driver); Thread.sleep(5000); 
	 * loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	 * 
	 * Thread.sleep(5000);
	 * 
	 * PIMPage pimPage = new PIMPage(driver); Thread.sleep(2000);
	 * pimPage.clickPIMMenu(); 
	 * Thread.sleep(2000); 
	 * pimPage.clickAddEmployeeBtn();
	 * Thread.sleep(2000);
	 * 
	 * // pimPage.addEmployee("Rajuu ", "Singh"); /*initial dierct pass
	 */

	/*
	 * After adding ExcelReader file 
	 * String firstName = ExcelUtils.getCellData("Employees", 1, 0); 
	 * String lastName = ExcelUtils.getCellData("Employees", 1, 1); 
	 * pimPage.addEmployee(firstName,lastName);
	 */
//		Thread.sleep(2000);
//		pimPage.clickSave();

	/*
	 * Thread.sleep(5000);
	 * Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
	 * Thread.sleep(5000); pimPage.page2SaveBtn(); }
	 */

	@Test(dataProvider = "EmployeeData", dataProviderClass = TestDataProvider.class)

	public void verifyAddEmployee(String firstName, String lastName) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(5000);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		Thread.sleep(5000);

		PIMPage pimPage = new PIMPage(driver);
		Thread.sleep(2000);
		pimPage.clickPIMMenu();
		Thread.sleep(2000);
		pimPage.clickAddEmployeeBtn();
		Thread.sleep(2000);
		pimPage.addEmployee(firstName,lastName);

		pimPage.clickSave();

		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
		Thread.sleep(5000);
		pimPage.page2SaveBtn();

	}
}
