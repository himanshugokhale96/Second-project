package com.katta.suma;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExcelImport {

    private static final String EXCEL_FILE_LOCATION = "C:\\temp\\Employee.xls";

    public static void main(String[] args) {

        Workbook workbook = null;
        try {

            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));

            Sheet sheet = workbook.getSheet(0);
            
            for(int j=2;j<17;j++)
            {
		        for(int i=0;i<7;i++)
		        {
			        Cell cell1 = sheet.getCell(i,j);
			        System.out.print(cell1.getContents()+" "); 
			     }
		        System.out.println("\n");
		      }
            
            
            /*
            for(int i = 2; i <= sheet.getRows();i++)
            {
            	Cell[] cell = sheet.getRow(i);
            	for(Cell ce: cell)
            	{
            		System.out.print(ce.getContents()+" ");
            		
            	}
            	
            	System.out.print("\n");
            	//System.out.println(cell.toString());
            }*/
        }
            // Test Count + :
            /*
            Cell cell2 = sheet.getCell(0, 1);
            System.out.println(cell2.getContents());        // 1

            Cell cell3 = sheet.getCell(1, 0);
            System.out.print(cell3.getContents() + ":");    // Result + :
            Cell cell4 = sheet.getCell(1, 1);
            System.out.println(cell4.getContents());        // Passed

            System.out.print(cell1.getContents() + ":");    // Test Count + :
            cell2 = sheet.getCell(0, 2);
            System.out.println(cell2.getContents());        // 2

            System.out.print(cell3.getContents() + ":");    // Result + :
            cell4 = sheet.getCell(1, 2);
            System.out.println(cell4.getContents());   */     // Passed 2

         catch (Exception e) {
            e.printStackTrace();
        }  finally {

            if (workbook != null) {
                workbook.close();
            }

        }

    }

}