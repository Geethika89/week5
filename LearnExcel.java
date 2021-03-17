package testng.day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class LearnExcel {

	public String[][] excelRead(String fileName) throws IOException {
		 FileInputStream file = new FileInputStream(new File("./TestData/"+fileName+".xls"));
		HSSFWorkbook wb = new HSSFWorkbook(file);
				//("./TestData/CreateLead.xls");
		
		HSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
		String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
		System.out.println(cellValue);
		data[i-1][j] = cellValue;
			}
		}
wb.close();
return data;
	}

}
