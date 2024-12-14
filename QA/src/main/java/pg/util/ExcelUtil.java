package pg.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static String TEST_DATA_SHEET = "../QA/TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	public ArrayList<String> readData(String sheetName) {
		String data=null;
		ArrayList<String> urlinfo=new ArrayList<String>();
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

		    int rowCount = sheet.getPhysicalNumberOfRows();
		    System.out.println(rowCount);
		    
		    for (int i = 1; i < rowCount; i++) 
		    {
		        Row row = sheet.getRow(i);
		        
		         for (int j = 0; j < row.getLastCellNum(); j++) {
		            data=row.getCell(j).toString();
				    System.out.println(data);
				    urlinfo.add(data);

		        }
		    	
		       }

		} 
		
	catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	
	catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	    System.out.println(data);

		return urlinfo;

	}
	
}
