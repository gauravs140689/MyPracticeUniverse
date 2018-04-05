package com.practice.extra.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.DocumentException;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

public class ExcelUtility {
	
	public void addRowandMergeCells(int rowNum,int colNum, String data, CellRangeAddress mergedRange, XSSFSheet sheet, XSSFWorkbook workbook, CellStyle headerCellStyle,boolean doCreateNew){
		Row row = null;
		if(doCreateNew)
			row = sheet.createRow(rowNum);
		else 
			row = sheet.getRow(rowNum);
		
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
	
	public void addBlankRow(int rowNum, XSSFSheet sheet){
		sheet.createRow(rowNum);
	}
	
	/*public void convertExcelToPdf(List<Object> rowColumns, String srcFile) throws FileNotFoundException, DocumentException{
		Document iText_xls_2_pdf = new Document();
        PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream(srcFile.substring(0,srcFile.lastIndexOf("\\"))+"Excel2PDF_Output.pdf"));
        iText_xls_2_pdf.open();
        //we have two columns in the Excel sheet, so we create a PDF table with two columns
        //Note: There are ways to make this dynamic in nature, if you want to.
        PdfPTable my_table = new PdfPTable(8);
        //We will use the object below to dynamically add new data to the table
        PdfPCell table_cell = null;
        
        for(Object obj : rowColumns){
        	if (obj instanceof String)
        		table_cell = new PdfPCell(new Phrase((String) obj));
			else if (obj instanceof Integer)
				table_cell = new PdfPCell(new Phrase((Integer) obj));
        	my_table.addCell(table_cell);
        }
        
        iText_xls_2_pdf.add(my_table);                       
        iText_xls_2_pdf.close();                
        //we created our pdf file..
        
	}
*/
}
