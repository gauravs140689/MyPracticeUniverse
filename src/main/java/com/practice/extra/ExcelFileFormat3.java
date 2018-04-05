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

public class ExcelFileFormat3 {

	public void generate(String srcFile, String destFile){
		 try
	        {
	            FileInputStream file = new FileInputStream(new File(srcFile));
	            
	            int rowNum=0;
	            int counterForRow = 0;
	            String extraColValue_even = "Tote %";
	            String extraColValue_odd = "Audit $";
	            
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
	            utility.addRowandMergeCells(rowNum, 1,"Format3 HeaderValue1", new CellRangeAddress(rowNum, rowNum, 1, 9), writer.sheet, writer.workbook, writer.headerCellStyle,true);
	            utility.addRowandMergeCells(rowNum, 10,"Format3 HeaderValue2", new CellRangeAddress(rowNum, rowNum, 10, 17), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            rowNum++;
	            utility.addRowandMergeCells(rowNum, 2,"Audited Tote", new CellRangeAddress(rowNum, rowNum, 2, 3), writer.sheet, writer.workbook, writer.headerCellStyle,true);
	            utility.addRowandMergeCells(rowNum, 4,"Quantity", new CellRangeAddress(rowNum, rowNum, 4, 5), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 6,"Sub3", new CellRangeAddress(rowNum, rowNum, 6, 7), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 8,"Sub4", new CellRangeAddress(rowNum, rowNum, 8, 9), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 10,"Sub5", new CellRangeAddress(rowNum, rowNum, 10, 11), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 12,"Sub6", new CellRangeAddress(rowNum, rowNum, 12, 13), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 14,"Sub7", new CellRangeAddress(rowNum, rowNum, 14, 15), writer.sheet, writer.workbook, writer.headerCellStyle,false);
	            utility.addRowandMergeCells(rowNum, 16,"Sub8", new CellRangeAddress(rowNum, rowNum, 16, 17), writer.sheet, writer.workbook, writer.headerCellStyle,false);
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
	                	writer.writeToWorkbook("",2,rowNum,rowColumns, true);
	                }else{
	                	if(rowNum>1 && isEven(counterForRow)){
		                	writer.writeToWorkbook(extraColValue_even,2,rowNum,rowColumns, false);
		                }else{
		                	writer.writeToWorkbook(extraColValue_odd,2,rowNum,rowColumns, false);
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
