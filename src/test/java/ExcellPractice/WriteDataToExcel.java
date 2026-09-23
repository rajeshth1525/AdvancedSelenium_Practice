package ExcellPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis1= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Data");
		Row r = sh.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("ChotaBabu");
		FileOutputStream fos=new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		fis1.close();
		System.out.println("Data Written Succssfully in excell");
	
	}

}
