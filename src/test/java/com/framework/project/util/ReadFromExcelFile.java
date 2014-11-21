package com.framework.project.util;

public class ReadFromExcelFile extends Excel {
	//public static void main(String args[]) throws Exception{
	public String[] getUserName() throws Exception{
		Excel ex = new Excel();
		String arr[] = new String[5]; 
		String user2;
		ex.setExcel("src/test/resources/Data/LoginDetails.xls","Sheet1");
		for(int i=1;i<=ex.gettotalRows();i++){
		arr[0]= ex.getCellValue(i,1);
		arr[1] = ex.getCellValue(i,2);
		System.out.println("$$$$$$"+arr[0]);
		//System.out.println(arr[0]+"^^^^^^^^"+arr[1]);
		}
		return arr;
	
	}
}
