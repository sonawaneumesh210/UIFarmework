package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet2 {

	public static void main(String[] args) throws IOException {
		String path = "C:/Users/Usonawane/eclipse-workspace/UiFramework/src/main/resources/creds_sheet.xlsx";
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		
		int sheetCount=workbook.getNumberOfSheets();
		System.out.println(sheetCount);
		
		
		for(int i=0;i<sheetCount;i++) {
			System.out.println(workbook.getSheetName(i));
		}
		
		XSSFSheet sheet = workbook.getSheet("creds");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		System.out.println("rowCount :"+rowCount);
		
		 int totalRows = sheet.getPhysicalNumberOfRows();
		 XSSFRow rowObject = sheet.getRow(0);
	     int totalCols = rowObject.getPhysicalNumberOfCells();
	     
	 	 System.out.println("totalCols :"+totalCols);
	        
	 	 
	 	 String cellValue=sheet.getRow(0).getCell(1).toString();
	 	 
	 	 System.out.println("cellValue :"+cellValue);
	 	 
	 	 // =============================================
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	        Object[][] data = new Object[totalRows - 1][totalCols];

	        // Start from 1 → skip header
	        for (int i = 1; i < totalRows; i++) {
	        	
	            for (int j = 0; j < totalCols; j++) {

	                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
	            }
	        }
	        
	        for(int i=0;i<data.length-1;i++) {
	        	for(int j=0;j<data.length-1;j++) {
	        		System.out.print(data[i][j]);
	        	}
	        	 System.out.println();
	        }
	       

	}
}
