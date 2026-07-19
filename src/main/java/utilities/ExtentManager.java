package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/AutomationReport.html");
            
            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("OrangeHRM Automation");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Preet");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");

        }

        return extent;

    }

}