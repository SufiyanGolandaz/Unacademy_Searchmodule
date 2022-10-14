package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelReader() throws IOException {
		File file = new File("C:\\Users\\safzalgo\\eclipse-workspace\\Unacademy_SearchModule\\src\\test\\resources\\dataSource\\DataSource.xls");
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}
	
	public XSSFSheet getEnquiryFormSheet() {
		return sheet;
	}
	
	public int rowCount() {
		return sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
	}
	
	public int colCount() {
		return sheet.getRow(0).getLastCellNum();
	}
}

