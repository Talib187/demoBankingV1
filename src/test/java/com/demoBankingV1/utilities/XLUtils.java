package com.demoBankingV1.utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLUtils {

	public static String getCellData(String xlsFile, String xlsheet, int rownum, int cellnum) throws IOException {
	    FileInputStream fis = new FileInputStream(xlsFile);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sh = wb.getSheet(xlsheet);
	    XSSFRow row = sh.getRow(rownum);
	    XSSFCell cell = row.getCell(cellnum);

	    String cellData = "";

	    if (cell != null) {
	        switch (cell.getCellType()) {
	            case STRING:
	                cellData = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                // Handle numeric values
	                cellData = String.valueOf(cell.getNumericCellValue());
	                break;
	            case BOOLEAN:
	                // Handle boolean values
	                cellData = String.valueOf(cell.getBooleanCellValue());
	                break;
	            // Handle other cell types if needed
	            default:
	                cellData = ""; // Default value for unsupported cell types
	        }
	    }

	    wb.close();
	    fis.close();
	    return cellData;
	}



    public static int getRowCount(String xlsFile, String xlsheet) throws IOException {
        FileInputStream fis = new FileInputStream(xlsFile);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sh = wb.getSheet(xlsheet);
        int rowCount = sh.getLastRowNum();

        wb.close();
        fis.close();

        return rowCount;
    }

    public static int getCellCount(String xlsFile, String xlsheet, int rownum) throws IOException {
        FileInputStream fis = new FileInputStream(xlsFile);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sh = wb.getSheet(xlsheet);
        XSSFRow row = sh.getRow(rownum);

        int cellCount = row.getLastCellNum();

        wb.close();
        fis.close();

        return cellCount;
    }
}
