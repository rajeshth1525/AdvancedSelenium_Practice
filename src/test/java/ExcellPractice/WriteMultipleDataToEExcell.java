package ExcellPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataToEExcell {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("Details");
		
		Row r1 = sh.createRow(0);
		r1.createCell(0).setCellValue("Name");
		r1.createCell(1).setCellValue("Country");
		r1.createCell(2).setCellValue("Result");
		
		Row r2 = sh.createRow(1);
		r2.createCell(0).setCellValue("Shubhangi");
		r2.createCell(1).setCellValue("India");
		r2.createCell(2).setCellValue("Married with Rajesh");
		
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
		System.out.println("Multiple data added in Details sheet");
	}

}
