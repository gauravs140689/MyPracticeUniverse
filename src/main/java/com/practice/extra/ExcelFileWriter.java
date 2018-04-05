package com.practice.extra;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileWriter {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	CellStyle cellStyle;
	CellStyle cellStyleWithBold;
	CellStyle headerCellStyle;
	int currentRowNum;
	Row currentRow ;
	
	public ExcelFileWriter(String workbookName){
		workbook = new XSSFWorkbook();
		//Create a blank sheet
		sheet= workbook.createSheet(workbookName);
		currentRow = sheet.createRow(0);
		
		//create cell Style
		cellStyle = workbook.createCellStyle();
		setDefaultCellStyle(cellStyle);
		
		cellStyleWithBold= workbook.createCellStyle();
		setCellStyleWithBold(cellStyleWithBold);
		
		//Set header style
		headerCellStyle=workbook.createCellStyle();
		setHeaderCellStyle(headerCellStyle);
		
		
	}
	
	
	public void writeToWorkbook(String firstColumnValue, int startColumn, int rownum, List<Object> data, boolean isFirstRowFRomRead) {

		Row row = sheet.createRow(rownum);
		if(startColumn>0){
			Cell cell = row.createCell(startColumn-1);
			cell.setCellValue(firstColumnValue);
			cell.setCellStyle(cellStyle);
		}
		int cellnum = startColumn;
		for (Object obj : data) {
			Cell cell = row.createCell(cellnum++);
			if (obj instanceof String)
				cell.setCellValue((String) obj);
			else if (obj instanceof Integer)
				cell.setCellValue((Integer) obj);
			//Add cell style to all cells in each row
			if(isFirstRowFRomRead){
				cell.setCellStyle(cellStyleWithBold);
			}else{
				cell.setCellStyle(cellStyle);
			}
		}
	}

	public void writeToWorkbook(Map<String, List<String>> inputMap) {

		int rownum = 1;
		for (Entry<String, List<String>> e : inputMap.entrySet()) {
			int colNum = 1;
			List<String> entry = e.getValue();
			Row row = sheet.createRow(rownum);
			for(String col: entry){
				Cell cell = row.createCell(colNum-1);
				cell.setCellValue(col);
				colNum++;
			}
			rownum++;
		}
	}
	
	public void addWorkbookToFile(String fileName){

        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(fileName));
            workbook.write(out);
            out.close();
            System.out.println(fileName+" :  written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
	
	public void addRowandMergeCells(int rowNum,int colNum, String data, CellRangeAddress mergedRange){
		Row row = null;
		if(currentRowNum==rowNum){
			row = currentRow;
		}else{
			row = sheet.createRow(rowNum);
			currentRow = row;
			currentRowNum = rowNum;
		}
		
		
		Cell cell = row.createCell(colNum);
		cell.setCellValue(data);
		
		//add cell Style to header cell
		cell.setCellStyle(headerCellStyle);
		sheet.addMergedRegion(mergedRange);
		
		//Set thick Border around Header
		RegionUtil.setBorderBottom(CellStyle.BORDER_THICK, mergedRange, sheet, workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THICK, mergedRange, sheet, workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THICK, mergedRange, sheet, workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THICK, mergedRange, sheet, workbook);
		
	}
	
	private void setDefaultCellStyle(CellStyle cellStyle){
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
	}
	
	private void setCellStyleWithBold(CellStyle cellStyle){
		setDefaultCellStyle(cellStyle);
		XSSFFont boldFont = workbook.createFont();
		boldFont.setBold(true);
		cellStyle.setFont(boldFont);
		cellStyle.setWrapText(true);
	}

	private void setHeaderCellStyle(CellStyle cellStyle){
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		//Add Font color to header
		XSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setBold(true);
		cellStyle.setFont(font);
		//add background color for header
		cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	}
	
}
