package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.PIMPage;
import utilities.ConfigReader;

public class TC_EMP_001_AddEmployee  extends BaseClass{
	
	@Test
	public void verifyAddEmployee() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(5000);
		loginPage.login(
	            ConfigReader.getProperty("username"),
	            ConfigReader.getProperty("password"));
		
		Thread.sleep(5000);
		
		PIMPage pimPage = new PIMPage(driver);
		Thread.sleep(2000);
		pimPage.clickPIMMenu();
		Thread.sleep(2000);
		pimPage.clickAddEmployeeBtn();
		Thread.sleep(2000);
		pimPage.addEmployee("Rajuu ", "Singh");
//		Thread.sleep(2000);
//		pimPage.clickSave();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
		Thread.sleep(5000);
		pimPage.page2SaveBtn();	
	}
}
