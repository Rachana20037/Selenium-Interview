package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class DashboardTest extends BaseClass {
	@Test
	public void verifyLogin() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		DashboardPage dashboardPage = new DashboardPage(driver);

		/*
		 * Refactor in Thread.sleep dashboardPage.profileClick(); Thread.sleep(3000);
		 * waitUtils.waitForElementVisible(logoutBtn);
		 */
		Assert.assertTrue(dashboardPage.isDashboardDisplayed());
		dashboardPage.logoutBtn();

	}
}
