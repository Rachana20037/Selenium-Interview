package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.PIMPage;
import utilities.ConfigReader;

public class TC_EMP_003_DeleteEmployee extends BaseClass {
	@Test
	public void verifyDeleteEmployee() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		
		PIMPage pimPage = new PIMPage(driver);

		pimPage.clickPIMMenu();
//	    pimPage.searchEmployee("Bala Kumar");
//	    pimPage.searchEmployee();
	    Thread.sleep(2000);
	    pimPage.deleteEmp();
	    Thread.sleep(2000);
	    pimPage.searchEmployee("Bala Kumar");
	    Assert.assertTrue(pimPage.isNoRecordFoundDisplayed());
	    
//	    Assert.assertTrue(pimPage.isNoRecordFoundDisplayed());
	}
	 
}
