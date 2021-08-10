package DataReader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelReader {

	
	public String[][] readExcel(String filePath, String fileName, String sheetName){
		
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		String[][] excelArray = null;
		if(fileExtensionName.equals(".xlsx")) {
			
			workbook = new XSSFWorkbook(inputStream);
	
		}
		
		else if(fileExtensionName.equals(".xlx")) {
			
			workbook = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum().sheet.getFirstRowNum();
		excelArray = new String[rowCount+1][1];
		for(int i = 0; i < rowCount + 1; i++) {
			
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++) 
			{
				if(row.getCell(j).getCellType().toString().contains("NUMERIC")) {
					
					excelArray[i][j]= String.valueOf(row.getCell(j).getNumericCellValue());
					
				}
				else {
					excelArray[i][j] = row.getCell(j).getStringCellValue().toString();
				}
				
				System.out.println(row.getCell(j).getStringCellValue().toString());
			}
			System.out.println();
		}
		
		return excelArray;
	}
}
