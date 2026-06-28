package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtils;

/* This class is not related to DataProvider. It is just a utility verification test.Its only job is to verify that ExcelUtils is reading Excel correctly.

*/
public class ExcelReadTest {
	 @Test
	    public void verifyExcelRead() {

	        String firstName = ExcelUtils.getCellData("Employees",1,0);

	        System.out.println("First Name : " + firstName);

	        Assert.assertNotNull(firstName);

	        Assert.assertEquals(firstName, "Bala");
	    }
	/*@Test
    public void verifyExcelRead() {

        String filePath = "C:/Users/racha/eclipse-workspace/Seleniumi-Interview/Selenium_Interview/resources/testdata/EmployeeData.xlsx";

//        String firstName = ExcelUtils.getCellData(filePath,"Employees",1,0);
        public static String getCellData(String sheetName,int rowNum,int colNum);
        System.out.println("First Name : " + firstName);

        Assert.assertNotNull(firstName);

        Assert.assertEquals(firstName, "Bala");
    }
	*/
}