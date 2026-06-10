package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class DashboardTest extends BaseClass{
	@Test
    public void verifyLogin() throws InterruptedException {
		
		 LoginPage loginPage = new LoginPage(driver);

		 Thread.sleep(5000);
		    loginPage.login(
		            ConfigReader.getProperty("username"),
		            ConfigReader.getProperty("password"));

		    Thread.sleep(3000);
    
        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        dashboardPage.profileClick();
        Thread.sleep(3000);
//        dashboardPage.logoutBtn();

    }	
}
