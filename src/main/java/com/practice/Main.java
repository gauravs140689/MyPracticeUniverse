package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.practice.extra.Employee;
import com.practice.extra.ExcelFileWriter;
import com.practice.extra.TestService;

public class Main {

	public static void main(String[] args) throws Exception {

		/*String s1 = "hello";
		HashSet<String> inValidDataRecName = new HashSet<String>();
		inValidDataRecName.add("hello");
		
		System.out.println(inValidDataRecName.contains(s1));
		*/
		
		String srcFile="D:\\Sophia\\data\\input.xlsx";
		Map<String, List<String>> inputMap = new HashMap<String, List<String>>();
		populateInput(srcFile, inputMap);
		TestService ts = new TestService();
        
        for(Entry<String, List<String>> e: inputMap.entrySet()){
        	List<String> inputEntry = e.getValue();
        	List<String> empIds = Arrays.asList(inputEntry.get(1).split(","));
        	String status = inputEntry.get(2);
        	
        	List<Employee> emps = ts.getEmployeeList(status, empIds);
        	
        	StringBuilder sb = new StringBuilder();
        	for(Employee emp: emps){
        		sb.append(emp.toString());
        		sb.append(":::");
        	}
        	inputEntry.add(sb.toString());
        }
        
        for(Entry<String, List<String>> e: inputMap.entrySet()){
        	System.out.println(e.getValue());
        }
        
        ExcelFileWriter writer = new ExcelFileWriter("Output");
        writer.writeToWorkbook(inputMap);
        writer.addWorkbookToFile("D:\\Sophia\\data\\output.xlsx");
		
		/*String[] sa = new String[4];
		System.out.println(sa);*/
		
		/*String keyValueString = "[]";
		List<String> keyValuesArrayList = new ArrayList<String>(Arrays.asList(keyValueString.substring(1, keyValueString.length()-1).split(",")));
		System.out.println(keyValuesArrayList.size());
		String s= keyValuesArrayList.get(0);
		if(!s.equals("") && s.substring(0, s.indexOf("#")).equals("category"))
			System.out.println("hello"+keyValuesArrayList.get(0)+"Gaurav");
		else
			System.out.println("hello"+keyValuesArrayList.get(0)+"Gaurav");*/
		
	}
	
	public static void populateInput(String srcFile, Map<String, List<String>> inputMap) throws IOException{
	
		FileInputStream file = new FileInputStream(new File(srcFile));
        
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        
        while(rowIterator.hasNext()){
        	Row row = rowIterator.next();
        	Iterator<Cell> cellIterator = row.iterator();
        	List<String> rowEntry = new ArrayList<String>();
        	while(cellIterator.hasNext()){
        		 Cell cell = cellIterator.next();
        		 rowEntry.add(cell.getStringCellValue());
        	}
        	inputMap.put(rowEntry.get(0), rowEntry);
        }
	}

}
