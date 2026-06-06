package testcases;


import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

//    @Test
//    public void launchApplication() {
//
//        System.out.println(driver.getTitle());
//
//    }
    
    @Test
    public void verifyLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

    }
}