package com.demoBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

public class XLCeateCustID  {


	 public static String createCustomerID(WebDriver driver, WebElement custId) {
	        // Perform actions to create customer ID using Selenium
	        WebElement customerIDElement = driver.findElement(By.id("customer_id_element_id"));
	        return customerIDElement.getText();
	    }

	    public static void saveCustomerIDToExcel(String customerID) throws IOException {
	        Workbook workbook;
	        try {
	            FileInputStream fileInputStream = new FileInputStream(new File("customer_ids.xlsx"));
	            workbook = new XSSFWorkbook(fileInputStream);
	        } catch (FileNotFoundException e) {
	            workbook = new XSSFWorkbook();
	        }

	        Sheet sheet = (Sheet) workbook.getSheetAt(0);

	        Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum() + 1);
	        Cell cell = (Cell) row.createCell(0);
	        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(customerID);

	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream(new File("customer_ids.xlsx"));
	            workbook.write(fileOutputStream);
	            fileOutputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
