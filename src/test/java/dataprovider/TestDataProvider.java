package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public class TestDataProvider {
	/*This is just to verify is it pick data multiple time and add emp
	 * @DataProvider(name = "EmployeeData")
	public Object[][] employeeData() {

		return new Object[][] {

				{ "Bala", "Kumar" }, { "Rahul", "Sharma" }, { "Raju", "Singh" }

		};

	}
	*/
	
//	This will read multiple data from excel and add emp 
	@DataProvider(name="EmployeeData")
	public Object[][] employeeData() {

	    return ExcelUtils.getExcelData("Employees");

	}
}
