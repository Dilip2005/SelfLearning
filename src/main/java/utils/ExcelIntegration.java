package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration {

	public static String[][] readValue(String filepath) throws IOException {
		

		XSSFWorkbook wb=new XSSFWorkbook("./data/"+filepath+".xlsx");
		
		
		XSSFSheet sheetAt = wb.getSheetAt(0);
	 
	 int rowcount = sheetAt.getLastRowNum();
	 
	 
	 int cellcount = sheetAt.getRow(1).getLastCellNum();
	
	 //step1
		String[][] data=new String[rowcount][cellcount];

	 for (int i = 1; i <=rowcount; i++) {
	
		 for (int j = 0; j < cellcount; j++) {
			String value = sheetAt.getRow(i).getCell(j).getStringCellValue();
			
			//step 2
			data[i-1][j]=value;
		}
	}
	 
	 
		wb.close();
		//step 3
		 return data;


	}
}
