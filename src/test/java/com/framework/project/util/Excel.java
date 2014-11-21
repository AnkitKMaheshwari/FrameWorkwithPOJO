package com.framework.project.util;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel {

	private FileInputStream file;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFCell cell;
	private DataFormatter formatter;

	public void setExcel(String path, String sheetName) throws Exception
	{

		file = new FileInputStream(path);

		workbook = new HSSFWorkbook(file);
		// if you  have sheet name then do it
		sheet = workbook.getSheet(sheetName);

	}


	public String getCellValue(int row, int column)
	{
		//System.out.println(row+"sdsds"+column);
		cell = sheet.getRow(row).getCell(column);
		formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
		// This method have disadvantages
		//return cell.getStringCellValue();


	}
	public int gettotalRows() {
		// TODO Auto-generated method stub
		return sheet.getLastRowNum();
	}

	public int getTotalColumns(int row){
		return sheet.getRow(row).getLastCellNum();
	}

}
