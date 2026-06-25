package utilities;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	String filePath =
			"src/test/resources/testdata/EmployeeData.xlsx";

			
    public static String getCellData(String filePath,String sheetName,int rowNum,int colNum) {

        try {

            FileInputStream fis =new FileInputStream(filePath);
            System.out.println(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

            workbook.close();

            return data;

        }

        catch(Exception e) {

            e.printStackTrace();

            return null;

        }

    }

}