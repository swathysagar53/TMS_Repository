package com.TrainerManagementSystem.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public static FileInputStream fin;
	public static FileOutputStream fou;
	public static XSSFWorkbook wb;
	public static XSSFSheet wst;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlFile,String xlSheet) throws IOException {
		
		fin=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fin);
		wst=wb.getSheet(xlSheet);
		int rowcount=wst.getLastRowNum();
		wb.close();
		fin.close();
		return rowcount;
	}
	
	
    public static int getCellCount(String xlFile,String xlSheet,int rownum) throws IOException {
		
		fin=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fin);
		wst=wb.getSheet(xlSheet);
		row=wst.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fin.close();
		return cellcount;
	}
    
   public static String getCellData(String xlFile,String xlSheet,int rownum,int colnum) throws IOException {
		
		fin=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fin);
		wst=wb.getSheet(xlSheet);
		row=wst.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData= formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e){
			
			data="";
		}
		
		wb.close();
		fin.close();
		return data;
	}
   
   
   public static void setCellData(String xlFile,String xlSheet,int rownum,int colnum,String data) throws IOException {
		
		fin=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fin);
		wst=wb.getSheet(xlSheet);
		row=wst.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fou=new FileOutputStream(xlFile);
		wb.write(fou);
		wb.close();
		fin.close();
		fou.close();
   }
		
}

