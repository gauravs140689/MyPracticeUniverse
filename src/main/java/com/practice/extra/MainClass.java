package com.practice.extra;

import java.io.IOException;
import java.text.ParseException;

public class MainClass {

	static int N = 5;
	public static void main(String[] args) throws IOException, ParseException {
		
		System.out.println("Started.....");
		System.out.println("In Main Master");
		
		System.out.println("In Repo Master");
		/*String dirPath = "D:\\temp'\\files";
		File dir = new File(dirPath);
		if(dir.exists()){
			File[] files = dir.listFiles();
			for(File file:files){
				String fileName = file.getName();
				String[] splits = fileName.split("_");
				String fileKey = splits[splits.length-3];
				String filePath = dirPath+"\\"+fileName;
				if(fileKey.equals("audited")){
					ExcelFileFormat1 format1 = new ExcelFileFormat1();
					format1.generate(filePath, "D:\\temp'\\data\\write.xlsx");
				}else if(fileKey.equals("accu")){
					ExcelFileFormat2 format2 = new ExcelFileFormat2();
					format2.generate(filePath, "D:\\temp'\\data\\write.xlsx");
				}else if(fileKey.equals("comp")){
					ExcelFileFormat3 format3 = new ExcelFileFormat3();
					format3.generate(filePath, "D:\\temp'\\data\\write.xlsx");
				}else if(fileKey.equals("del")){
					ExcelFileFormat4 format4 = new ExcelFileFormat4();
					format4.generate(filePath, "D:\\temp'\\data\\write.xlsx");
				}
			}
		}*/
		
		//ExceltoPdfFormat1 pdfformat1 = new ExceltoPdfFormat1();
		//pdfformat1.generate("D:\\temp'\\data\\write.xlsx", "D:\\temp'\\data\\write.xlsx");
		
		//ExceltoPdfFormat2 pdfformat2 = new ExceltoPdfFormat2();
		//pdfformat2.generate("D:\\temp'\\data\\write.xlsx", "D:\\temp'\\data\\write.xlsx");
		
		/*ExcelFileFormat3 format3 = new ExcelFileFormat3();
		format3.generate("D:\\temp'\\data\\format3_input.xlsx", "D:\\temp'\\data\\write.xlsx");
		ExceltoPdfFormat3 pdfformat3 = new ExceltoPdfFormat3();
		pdfformat3.generate("D:\\temp'\\data\\write.xlsx", "D:\\temp'\\data\\write.xlsx");*/
		
		/*ExcelFileFormat1 format1 = new ExcelFileFormat1();
		format1.generate("D:\\temp'\\data\\row_data_201607.xlsx", "D:\\temp'\\data\\write.xlsx");*/
		
		//ExcelFileFormat2 format2 = new ExcelFileFormat2();
		//format2.generate("D:\\temp'\\data\\format2_input.xlsx", "D:\\temp'\\data\\write.xlsx");
		
		//ExcelFileFormat3 format3 = new ExcelFileFormat3();
		//format3.generate("D:\\temp'\\data\\format3_input.xlsx", "D:\\temp'\\data\\write.xlsx");
		
		//ExcelFileFormat4 format4 = new ExcelFileFormat4();
		//format4.generate("D:\\temp'\\data\\format4_input.xlsx", "D:\\temp'\\data\\write.xlsx");
		//ExceltoPdfFormat4 pdfformat4 = new ExceltoPdfFormat4();
		//pdfformat4.generate("D:\\temp'\\data\\write.xlsx", "D:\\temp'\\data\\write.xlsx");
		
		//Desktop.getDesktop().open(new File("D:\\temp'\\data\\Output.pdf"));
		
		//reverseString("I am hero");
		
		//crate the product array
		/*int[] ar = {2,4,1,3,5};
		System.out.println("Original: ");
		for(int i : ar){
			System.out.print(i+ "      ");
		}
		
		multiply(ar, 1, 0);
		
		System.out.println("\n\nProduct: ");
		for(int i : ar){
			System.out.print(i+ "      ");
		}*/
		
		Thread t = new Thread(()->{
			while(true){
				System.out.println("Hello");
			}
		});
		
		t.start();
		
		System.out.println("Added in ChangeForMain");
		System.out.println("Added in Master");
		System.out.println("Done");
	}
	
	static int multiply(int[] a, int fwdProduct, int indx) {
	    int revProduct = 1;
	    if (indx < N) {
	       System.out.println("\n    Index:"+indx);		
	       revProduct = multiply(a, fwdProduct*a[indx], indx+1);
	       int cur = a[indx];
	       a[indx] = fwdProduct * revProduct;
	       System.out.println("fwdProduct: "+fwdProduct +"and revProduct: "+revProduct);
	       
	       //System.out.println("a["+indx+"]:"+a[indx]);
	       revProduct *= cur;
	    }
	    return revProduct;
	}
	

	static void reverseString(String s){
		//Using Array
		char[] cArr = s.toCharArray();
		
		for(int i=0; i<= s.length()/2;i++){
			char temp = cArr[i];
			cArr[i]= cArr[s.length()-1-i];
			cArr[s.length()-1-i] = temp;
		}
		for(char c : cArr){
			System.out.print(c);
		}
		
		
		//Using Stack
		
		/*Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			stack.push(s.charAt(i));
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}*/
				
	}

}
