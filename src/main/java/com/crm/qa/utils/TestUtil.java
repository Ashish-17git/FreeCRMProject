package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;

public class TestUtil {

	static String TESTDATA_SHEET_PATH = null;
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT = 10;
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book= WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i =0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

//	public static void takeScreenshotAtEndOfTest() throws IOException {
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//	}
}
