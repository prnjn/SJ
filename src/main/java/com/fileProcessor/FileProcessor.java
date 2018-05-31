package com.fileProcessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.ApplicationConstants;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class FileProcessor {

	
	private String outFileName=StringUtils.EMPTY;
	private String outPath="./";
	private String outFileExtention= ".xlsx";	
	
	public boolean processFile() {
		boolean isProcessed = false;
		
		try {
			FileInputStream file = new FileInputStream(new File(ApplicationConstants.excelFilePath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Cell cell_total = null;
			
			//update value of cell
			cell_total = sheet.getRow(1).getCell(2,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			cell_total.setCellValue(2500);
			
			file.close();
			
			outFileName = "EditedWorkbook";
			FileOutputStream outFile = new FileOutputStream(new File(outPath+outFileName+outFileExtention));
			workbook.write(outFile);
			
			System.out.println("File writing completed");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isProcessed;
	}
	
	public static void main(String[] args) {
		FileProcessor fp = new FileProcessor();
		fp.processFile();

	}

}
