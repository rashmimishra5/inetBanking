package com.inetBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow rw;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		try 
		{
			fis=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet=wb.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		try 
		{
			fis=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet=wb.getSheet(xlsheet);
		rw=sheet.getRow(rownum);
		int cellcount=rw.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
		
	}
	
	public static int getCellcount(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		try 
		{
			fis=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet=wb.getSheet(xlsheet);
		rw=sheet.getRow(rownum);
		int cellcount=rw.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
		
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		try 
		{
			fis=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet=wb.getSheet(xlsheet);
		rw=sheet.getRow(rownum);
		cell=rw.getCell(colnum);
		String data;
		try 
		{
			DataFormatter df=new DataFormatter();
			String cellData=df.formatCellValue(cell);
			return cellData;
			
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		try 
		{
			fis=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet=wb.getSheet(xlsheet);
		rw=sheet.getRow(rownum);
		cell=rw.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		int cellcount=rw.getLastCellNum();
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
		
	}
}
