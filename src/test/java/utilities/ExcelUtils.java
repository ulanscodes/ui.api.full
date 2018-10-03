package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static String pathStr;

	// method that opens the excel sheet

	public static void openExcelSheet(String path, String sheetName) {
		pathStr = path;
		
		try {
			FileInputStream excelFile = new FileInputStream(path);
			
			workbook = new XSSFWorkbook(excelFile);
			sheet = workbook.getSheet(sheetName);
			
			
			
		} catch (IOException e) {
			System.out.println("Excel file not found");
			e.printStackTrace();
		}
	}
	
	
	//method that returns used rows
	public static int getUsedRows() {
		
		int rows = sheet.getPhysicalNumberOfRows();
		return rows;
		
	}
	
	//method that reads a value with the coordinates --> row and the coluns 
	
	public static String getData(int rowNum, int columnNum) {
		try {
			
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		
		return cell.toString();
	
	} catch (Exception e) {
	return "";
	}
	}
	
	// method that writes a value with the row and column
	
	public static void setData(String value, int rowNum, int columnNum) throws IOException {
		
		if (rowNum > sheet.getPhysicalNumberOfRows()) {
			row = sheet.createRow(columnNum);
		}else {
			
		row = sheet.getRow(rowNum);
		}
		
		
		cell = row.getCell(columnNum);
		
		
		cell.setCellValue(value);
		
		try {
			FileOutputStream out = new FileOutputStream(pathStr);
			
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		
		}
		
		workbook.close();
		
	}



}
