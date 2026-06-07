package testcases;


import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseClass {

//    @Test
//    public void launchApplication() {
//
//        System.out.println(driver.getTitle());
//
//    }
    
    @Test
    public void verifyLogin() throws InterruptedException {
    	
    	Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);

//        loginPage.login("Admin", "admin123");
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

    }
}