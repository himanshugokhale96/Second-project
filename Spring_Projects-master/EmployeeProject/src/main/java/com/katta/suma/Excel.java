package com.katta.suma;

import jxl.Workbook;

import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;

public class Excel {


		

		    private static final String EXCEL_FILE_LOCATION = "C:\\temp\\myFirstExcel.xls";

		    public static void main(String[] args) {

		        //1. Create an Excel file
		        WritableWorkbook myFirstWbook = null;
		        try {
		        	int col1 = 1;
		        	int col2 = 2;
		        	int row1 = 0;
		        	int row2 = 0;

		        	
		            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
		            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
		            // Table Headings
		            WritableFont cellFont = new WritableFont(WritableFont.TIMES, 16);
		            cellFont.setBoldStyle(WritableFont.BOLD);
		            
		            WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
		            
		            //Table Columns
		            WritableFont cellFont1 = new WritableFont(WritableFont.TIMES, 12);
		            cellFont1.setBoldStyle(WritableFont.BOLD);
		            WritableCell c = excelSheet.getWritableCell(0,0);
		            WritableCellFormat cellFormat1 = new WritableCellFormat(cellFont1);
		            cellFormat1.setBackground(Colour.YELLOW);
		            c.setCellFormat(cellFormat1);
		            // create an Excel sheet

		            excelSheet.mergeCells(col1,row1,col2,row2); 
		        	//This makes the cell at row1 and col1 span the next two cells
		        	//Write content at the marge cell
		        	excelSheet.addCell(new Label(col1,row1,"My Table",cellFormat));
		        	

		            // add something into the Excel sheet
		            Label label = new Label(0, 3, "Test Count",cellFormat1);
		            excelSheet.addCell(label);

		            Number number = new Number(0, 4, 1);
		            excelSheet.addCell(number);

		            label = new Label(1, 3, "Result",cellFormat1);
		            excelSheet.addCell(label);

		            label = new Label(1, 4, "Passed");
		            excelSheet.addCell(label);

		            number = new Number(0, 5, 2);
		            excelSheet.addCell(number);

		            label = new Label(1, 5, "Passed 2");
		            excelSheet.addCell(label);

		            myFirstWbook.write();
		            System.out.println("sucess");


		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (WriteException e) {
		            e.printStackTrace();
		        } finally {

		            if (myFirstWbook != null) {
		                try {
		                    myFirstWbook.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                } catch (WriteException e) {
		                    e.printStackTrace();
		                }
		            }


		        }

		    }

	

}


