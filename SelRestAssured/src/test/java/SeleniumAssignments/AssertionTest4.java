package SeleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;

public class AssertionTest4 {
    
  @Test
  public void f() throws Exception {
	  
	  String filepath="C:\\Users\\Admin\\Downloads\\Book1.xlsx";
	  FileInputStream fis=new FileInputStream(filepath);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sh=wb.getSheet("Sheet1");
	  int rowcount=sh.getLastRowNum()-sh.getFirstRowNum();
	  for(int i=0;i<=rowcount;i++) {
		  
		  String fname=sh.getRow(i).getCell(0).getStringCellValue();
		  String lname=sh.getRow(i).getCell(1).getStringCellValue();
		  double id=sh.getRow(i).getCell(2).getNumericCellValue();
		  
		  System.out.println("First Name: "+fname);
		  System.out.println("Last Name: "+lname);
		  System.out.println("ID: "+id);


	  }
  }
  
  
}
