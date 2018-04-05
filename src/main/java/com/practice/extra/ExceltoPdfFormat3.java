package com.practice.extra;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class ExceltoPdfFormat3 {

	public void generate(String srcFile, String destFile) {
		try {
			FileInputStream file = new FileInputStream(new File(srcFile));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
			PdfWriter pdfWriter = new PdfWriter(srcFile.substring(0,srcFile.lastIndexOf("\\")+1)+"Output.pdf");
			PdfDocument pdf = new PdfDocument(pdfWriter);    
			Document document = new Document(pdf, PageSize.A4.rotate());
			document.setMargins(10, 10, 10, 10);
			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
			PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			
			Table table = new Table(new float[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2});
			table.setWidthPercent(100);

			int colCount = 0;
			int rowCount = 0;
			boolean isFirst=true;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				colCount = 0;
				while (cellIterator.hasNext()) {
					colCount++;
					Cell cell = cellIterator.next();
					if(rowCount==1){
						if(cell.getStringCellValue().equals(""))
							continue;
						if(colCount==1)
							process(table,cell.getStringCellValue(), bold, 9, true);
						else{
							process(table,cell.getStringCellValue(), bold, 8, true);
						}
						continue;
					}else if(rowCount==2){
						System.out.println(rowCount+" : "+colCount+" : "+cell.getStringCellValue());
						if(cell.getStringCellValue().equals(""))
							continue;
						if(colCount==1){
							process(table," ", bold, 1, true);
							process(table,cell.getStringCellValue(), bold, 2, true);
						}else
							process(table,cell.getStringCellValue(), bold, 2, true);
						continue;
					}
					
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if(rowCount==3)
							process(table,(int)cell.getNumericCellValue()+"", bold, 1, false);
						else
							process(table,(int)cell.getNumericCellValue()+"", font, 1, false);
						break;
					case Cell.CELL_TYPE_BLANK:
						if(colCount!=1)
							process(table," ", font, 1, false);
						break;	
					case Cell.CELL_TYPE_STRING:
						if(cell.getStringCellValue().equals(""))
							process(table," ", font, 1, false);
						else
							if(rowCount==3)
								process(table,cell.getStringCellValue() , bold, 1, false);
							else
								process(table,cell.getStringCellValue() , font, 1, false);
						break;
					}
				}
				rowCount++;
			}
			document.add(table);
			document.close();
			file.close();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void process(Table table, String cellValue, PdfFont font, int colSpan, boolean isHeader) {
		com.itextpdf.layout.element.Cell pdfCell = new com.itextpdf.layout.element.Cell(1, colSpan);
		pdfCell.setTextAlignment(TextAlignment.CENTER);
		if (isHeader) {
			pdfCell.setBackgroundColor(Color.BLUE);
			pdfCell.setFontColor(Color.WHITE);
			table.addHeaderCell(pdfCell.add(new Paragraph(cellValue).setFont(font)));
		} else {
			table.addCell(pdfCell.add(new Paragraph(cellValue).setFont(font)));
		}
	}

}
