package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import utilities.ScreenshotUtils;

public class ScreenshotTest extends BaseClass {

    @Test
    public void verifyScreenshot() {

        ScreenshotUtils.captureScreenshot(driver, "OrangeHRM");

    }

}