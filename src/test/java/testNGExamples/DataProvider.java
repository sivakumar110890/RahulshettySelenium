package testNGExamples;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProvider {

	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "ArrayObjects")
	public void testCase(String firstData, String SecondData, String thirddata) {
		System.out.println(firstData + " : " + SecondData + " : " + thirddata);
	}

	@org.testng.annotations.DataProvider(name = "ArrayObjects")
	public Object[][] DataDriverFromExcel() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config/dataDriver.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowsCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int Columnscount = row.getLastCellNum();
		System.out.println("The Columns count : " + Columnscount);
		System.out.println("The Rows count : " + rowsCount);
		Object data[][] = new Object[rowsCount - 1][Columnscount];

		for (int i = 0; i < rowsCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < Columnscount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		return data;

	}

}
