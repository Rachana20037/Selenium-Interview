package testcases;

import org.testng.annotations.Test;

import utilities.ExcelUtils;

public class ExcelReadTest {

    @Test
    public void verifyExcelRead() {

        String firstName = ExcelUtils.getCellData("src/test/resources/testdata/EmployeeData.xlsx", "Employees",1,0);

//        String filePath ="src/test/resources/testdata/EmployeeData.xlsx";

//System.out.println(filePath);
        System.out.println(firstName);

    }
}