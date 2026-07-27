package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com");

        System.out.println("Edge launched successfully");

        driver.quit();
    }
}