package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	public String ToReadTheDatFromExcell(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis1= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		
	}

}
