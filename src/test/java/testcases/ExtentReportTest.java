package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import utilities.ExtentManager;

public class ExtentReportTest {

    @Test
    public void verifyExtentReport() {

        ExtentReports report =ExtentManager.getReport();

        report.flush();

    }

}