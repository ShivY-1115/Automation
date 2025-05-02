package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
  @Test
  public void f() throws IOException {
	  
	  File fis = new File("C:/Users/Srikar/OneDrive/Documents/Assignments/TestData.xlsx");
	  FileInputStream file = new FileInputStream(fis);
	  XSSFWorkbook workbook = new XSSFWorkbook(file);
	  XSSFSheet sheet = workbook.getSheet("TestData");
	  Iterator<Row> row = sheet.iterator();
	  ArrayList<Object> columndata = new ArrayList<>();
	  while (row.hasNext()) {
		  Row row1 = row.next();
		  Iterator<Cell> cell = row1.iterator();
		  while(cell.hasNext()) {
			  Cell cell1=cell.next();
			  if (row1.getRowNum()>=0) {
				  if(cell1.getColumnIndex()==0) {
					  switch(cell1.getCellType()) {
					  case NUMERIC:
						  columndata.add(cell1.getNumericCellValue());
						  break;
					  case STRING:
						  columndata.add(cell1.getStringCellValue());
						  break;
					  default:
						  break;
					  }
			  }
		  }
		  
	  }
	  }
	  if(columndata.contains("FlatnO")) {
		  int req_index = columndata.indexOf("FlatnO");
		  System.out.println(req_index);
		  System.out.println(columndata);
		  
		  Row requiredrow = sheet.getRow(req_index); 
	      String value = requiredrow.getCell(1).getStringCellValue(); System.out.println(value);
			 	  
		  }
	  
	  
  }
  
  public void excel() throws IOException {
	  File fis = new File("");
	  FileInputStream file = new FileInputStream(fis);
	  XSSFWorkbook workbook = new XSSFWorkbook(file);
	  XSSFSheet sheet= workbook.getSheetAt(0);
	  Iterator<Row> row = sheet.iterator();
	  ArrayList<Object> columndata = new ArrayList<>();
	  while(row.hasNext()){
		  Row row1 = row.next();
		  Iterator<Cell> cell = row1.iterator();
		  while(cell.hasNext()) {
			  Cell cell1 = cell.next();
			  if(row1.getRowNum()>=0) {
				  if(cell1.getColumnIndex()==0) {
					  switch (cell1.getCellType()){
					  case NUMERIC:
						  
					  }
				  }
			  }
		  }
	  }
	  
	  if (columndata.contains("name")){
		  int index = columndata.indexOf("name");
		  String value = sheet.getRow(index).getCell(1).getStringCellValue();
		  Row row23 = sheet.getRow(2);
		  Cell cell2 = row23.createCell(1);
		  cell2.setCellValue("Vamsi");
		  file.close();
		  FileOutputStream fid = new FileOutputStream(fis);
		  workbook.write(fid);
		  fid.close();
		  workbook.close();
		  
	  }
  }
  
  
}
