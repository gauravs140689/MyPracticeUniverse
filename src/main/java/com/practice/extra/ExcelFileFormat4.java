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

public class ExcelFileFormat4 {

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
	            utility.addRowandMergeCells(rowNum, 1,"Format4 HeaderValue", new CellRangeAddress(rowNum, rowNum, 1, 13), writer.sheet, writer.workbook, writer.headerCellStyle,true);
	            utility.addRowandMergeCells(rowNum, 14,"Format4 HeaderValue", new CellRangeAddress(rowNum, rowNum, 14, 23), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            rowNum++;
	            utility.addRowandMergeCells(rowNum, 1,"Location", new CellRangeAddress(rowNum, rowNum, 1, 5), writer.sheet, writer.workbook, writer.headerCellStyle,true);
	            utility.addRowandMergeCells(rowNum, 6,"Audited Tote", new CellRangeAddress(rowNum, rowNum, 6, 7), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 8,"Sub4", new CellRangeAddress(rowNum, rowNum, 8, 9), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 10,"Sub5", new CellRangeAddress(rowNum, rowNum, 10, 11), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 12,"Sub6", new CellRangeAddress(rowNum, rowNum, 12, 13), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 14,"Sub7", new CellRangeAddress(rowNum, rowNum, 14, 15), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 16,"Sub8", new CellRangeAddress(rowNum, rowNum, 16, 17), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 18,"Sub9", new CellRangeAddress(rowNum, rowNum, 18, 19), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 20,"Sub10", new CellRangeAddress(rowNum, rowNum, 20, 21), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 22,"Sub11", new CellRangeAddress(rowNum, rowNum, 22, 23), writer.sheet, writer.workbook, writer.headerCellStyle,false);
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
