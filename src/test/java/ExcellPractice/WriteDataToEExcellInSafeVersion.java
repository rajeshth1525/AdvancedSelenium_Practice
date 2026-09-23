package ExcellPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToEExcellInSafeVersion {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("NewData");
		if(sh==null)
		{
			sh=wb.createSheet("NewData");
		}
		
		Row r = sh.getRow(0);
		if(r==null)
		{
			r=sh.createRow(0);
		}
		
		Cell c = r.getCell(0);
		if(c==null)
		{
			c=r.createCell(0);
		}
		c.setCellValue("Yuvansh");
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
		System.out.println("Data Added in Safe Version");
	}

}
