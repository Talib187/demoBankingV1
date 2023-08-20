package com.demoBankingV1.utilities;

import java.io.IOException;

public class test {

	public void getData() throws IOException {

	//	String path = System.getProperty("user.dir" + "/src/test/java/com/demoBankingV1/testData/LoginData.xlsx");
		
		String path = "C:\\Users\\mtali\\eclipse-workspace\\demoBankingV1\\src\\test\\java\\com\\demoBankingV1\\testData\\LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colCount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colCount; j++) {

			System.out.println(logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j));
		
			}
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		
		test obj = new test();
		
		obj.getData();
	}
}
