package com.practice.extra;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.practice.extra.util.ExcelUtility;

public class ExcelFileFormat2 {

	public void generate(String srcFile, String destFile){
		 try
	        {
	            FileInputStream file = new FileInputStream(new File(srcFile));
	            
	            int rowNum=0;
	            int counterForRow = 0;
	            
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = sheet.iterator();
	            List<Object> rowColumns = new ArrayList<Object>();
	            ExcelFileWriter writer = new ExcelFileWriter("Employee Data");
	            
	            
	            //Add Header Row
	            //writer.addRowandMergeCells(rowNum, 0,"Employee Details", new CellRangeAddress(rowNum, rowNum, 0, 8));
	            ExcelUtility utility = new ExcelUtility();
	            utility.addBlankRow(rowNum, writer.sheet);
	            rowNum++;
	            utility.addRowandMergeCells(rowNum, 1,"Format2 Header", new CellRangeAddress(rowNum, rowNum, 1, 14), writer.sheet, writer.workbook, writer.headerCellStyle,true);
	            rowNum++;
	            utility.addRowandMergeCells(rowNum, 1,"Location", new CellRangeAddress(rowNum, rowNum, 1, 5), writer.sheet, writer.workbook, writer.headerCellStyle,true);
	            utility.addRowandMergeCells(rowNum, 6,"To be audited", new CellRangeAddress(rowNum, rowNum, 6, 8), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 9,"Audited", new CellRangeAddress(rowNum, rowNum, 9, 11), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 12,"Skipped", new CellRangeAddress(rowNum, rowNum, 12, 14), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            
	            /*writer.addRowandMergeCells(rowNum, 2,"Location", new CellRangeAddress(rowNum, rowNum, 2, 6));
	            writer.addRowandMergeCells(rowNum, 7,"To be audited", new CellRangeAddress(rowNum, rowNum, 7, 9));
	            writer.addRowandMergeCells(rowNum, 10,"Audited", new CellRangeAddress(rowNum, rowNum, 10, 12));
	            writer.addRowandMergeCells(rowNum, 13,"Skipped", new CellRangeAddress(rowNum, rowNum, 13, 15));*/
	            rowNum++;
	            while (rowIterator.hasNext()) 
	            {
	            	rowColumns.clear();
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                
	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                    switch (cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_NUMERIC:
	                            rowColumns.add((int)cell.getNumericCellValue());
	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                            rowColumns.add(cell.getStringCellValue());
	                            break;
	                    }
	                }
	                if(counterForRow==0){
	                	writer.writeToWorkbook("",1,rowNum,rowColumns, true);
	                }else{
	                	if(rowNum>1 && isEven(counterForRow)){
		                	writer.writeToWorkbook("",1,rowNum,rowColumns, false);
		                }else{
		                	writer.writeToWorkbook("",1,rowNum,rowColumns, false);
		                }
	                }
	                counterForRow++;
	                rowNum++;
	            }
	            writer.addWorkbookToFile(destFile);
	            file.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	}
	
	private boolean isEven(int value){
		return value%2==0;
	}
	
}
