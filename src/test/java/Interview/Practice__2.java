package Interview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map.Entry;

import org.apache.xmlbeans.impl.xb.xsdschema.Facet;

//import com.google.common.base.CaseFormat;
//import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes.Array;


public class Practice__2 
{
	public static void main()
	{
		LocalDate date = LocalDate.now();

		String month = date.format(DateTimeFormatter.ofPattern("MMMM"));   //September


		//Arrays.equals()
	}
	
	public static void main(String[] args) {
		
        main();
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		ArrayList<Object> array1 = new ArrayList<Object>();
		
		String str ="Hello world";
		for(char item:str.toCharArray()) {
			System.out.println(item);
		}
			          
	}


	/*
	 * public static void uploadfile() throws AWTException {
	 * stringselection("C://downloads//example.com"); Robot robo = new Robot();
	 * robo.keyPress(KeyEvent.VK_CONTROL); robo.keyPress(KeyEvent.VK_V);
	 * robo.keyRelease(KeyEvent.VK_CONTROL); robo.keyRelease(KeyEvent.VK_V);
	 * robo.keyPress(KeyEvent.VK_ENTER); robo.keyRelease(KeyEvent.VK_ENTER); }
	 * 
	 * public static void stringselection(String path) { StringSelection select =
	 * new StringSelection(path);
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
	 * 
	 * }
	 * 
	 * 
	 * for(int i=0;i<5;i++) {
	    	  for(int j=0;j<=i;j++) {
	    		  System.out.print("* ");
	    	  }
	    	  System.out.println();
	      }
	 * 
	 * 
	 */



		
		
	}


