package testcases;


import org.testng.annotations.Test;

import base.BaseClass;

public class LoginTest extends BaseClass {

    @Test
    public void launchApplication() {

        System.out.println(driver.getTitle());

    }
}