package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {



	public static Object[][] getDataFromExcel(String filePath, String sheetName) throws InvalidFormatException, IOException
	{//here getting excel data to an 2D(3x2) array using getDataFromExcel(path,value)
		// init
		Object[][] data;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook wb = WorkbookFactory.create(inputStream);
		Sheet s = wb.getSheet(sheetName);

		// sheet range
		int rowCount = s.getLastRowNum(); //4
		int colCount = s.getRow(0).getLastCellNum();//2

		// set data

		data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j <= colCount - 1; j++) {
				if (!getCellValue(s, 0, j).equals("")) {
					data[i - 1][j] = getCellValue(s, i, j);
				}
			}
		}

		return data;
	}

	// Get cell value at given row and column

	private static String getCellValue(Sheet sheet, int row, int col) {
		String value = "";
		if (sheet.getRow(row).getCell(col) == null) {
			value = "";
		} else if (sheet.getRow(row).getCell(col).getCellType() == Cell.CELL_TYPE_STRING) {
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		} else {
			sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		return value;
	}

	public static String getDataFromExcelrow(String filePath, String sheetName,int row_number,int column_number) throws InvalidFormatException, IOException
	{//here getting excel data to an 2D(3x2) array using getDataFromExcel(path,value)
		// init
		String data="";
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		Workbook wb = WorkbookFactory.create(inputStream);
		Sheet s = wb.getSheet(sheetName);
		

		// sheet range
		
		// set data

		
				if (!getCellValue(s, 0, column_number).equals("")) {
					data=getCellValue(s, row_number, column_number);
				}
		
	

		return data;
	}




}
