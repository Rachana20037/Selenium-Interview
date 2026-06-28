package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	/*
	 * String filePath
	 * ="C:/Users/racha/eclipse-workspace/Seleniumi-Interview/Selenium_Interview/resources/testdata/EmployeeData.xlsx";
	 * 
	 * 
	 * public static String getCellData(String filePath,String sheetName,int
	 * rowNum,int colNum) {
	 * 
	 * try {
	 * 
	 * FileInputStream fis = new FileInputStream(filePath);
	 * System.out.println("File Found");
	 * 
	 * XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 * System.out.println("Workbook Opened");
	 * 
	 * XSSFSheet sheet = workbook.getSheet(sheetName); System.out.println("Sheet = "
	 * + sheet);
	 * 
	 * System.out.println("Row = " + sheet.getRow(rowNum));
	 * 
	 * System.out.println("Cell = " + sheet.getRow(rowNum).getCell(colNum));
	 * 
	 * String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	 * return data;
	 */

	private static final String FILE_PATH = "C:/Users/racha/eclipse-workspace/Seleniumi-Interview/Selenium_Interview/resources/testdata/EmployeeData.xlsx";

	public static String getCellData(String sheetName, int rowNum, int colNum) {

		try {

			FileInputStream fis = new FileInputStream(FILE_PATH);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);

			String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			workbook.close();

			return data;

		}

		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static Object[][] getExcelData(String sheetName) {

		try {

			FileInputStream fis = new FileInputStream(FILE_PATH);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);

			int totalRows = sheet.getLastRowNum();

			int totalCols = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[totalRows][totalCols];

			/*
			 * for (int i = 1; i <= totalRows; i++) {

				for (int j = 0; j < totalCols; j++) {

					data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
				}

			}
			*/
			
			/* Interviewer: Why do we use DataFormatter instead of toString() while reading Excel?
Answer:DataFormatter returns the cell value exactly as displayed in Excel. It correctly handles different cell types like String, Number, Date, 
and Boolean without converting numbers to values like 1001.0 or dates to Excel serial numbers. This makes the data more reliable for automation tests.*/
			DataFormatter formatter = new DataFormatter();

			for (int i = 1; i <= totalRows; i++) {

			    for (int j = 0; j < totalCols; j++) {

			        data[i - 1][j] =
			                formatter.formatCellValue(
			                        sheet.getRow(i).getCell(j));

			    }

			}
			workbook.close();

			return data;

		}

		catch (Exception e) {

			 throw new RuntimeException("Failed to read Excel file.", e);

		}

	}

}