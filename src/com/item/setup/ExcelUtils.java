package com.item.setup;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	private static FileInputStream excelFile;
	private static String filePath;

	//This method is used to set the File path and to open the Excel file
	public static void setExcelFile() throws Exception {

		try {
			String workingDir = System.getProperty("user.dir");
			filePath = "/Users/brangas/Desktop/item_details.xlsx";
			excelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(filePath);
			System.out.println("govinda");
			ExcelWSheet = ExcelWBook.getSheet("item_detail");

		} catch (Exception e){
			e.printStackTrace();

		}

	}

	//This method is used to read the test data from the Excel cell, in this we are passing parameters as Row number and Column number and return the cell value

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		//System.out.println(ExcelWSheet.getRow(RowNum).getCell(ColNum).toString());
		setExcelFile();
		return ExcelWSheet.getRow(RowNum).getCell(ColNum).toString();
		// fill the code
	}
	public static Object[][] getExceldata(){
		return null;
		
	}




}


