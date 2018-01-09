/* This file ExcelUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	protected static Logger logger = Logger.getLogger(ExcelUtils.class);
	
	/**
	 * 创建一行数据
	 * @param filePath
	 * @param cells
	 * @throws Exception
	 * 创建人：  fming
	 * 创建时间：2013-8-30  下午4:26:19
	 */
	public static void createTemplate(String filePath,List<List<String>> _cells) throws Exception{
		String extension = filePath.lastIndexOf(".") == -1 ? "" : filePath.substring(filePath.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			FileOutputStream  out = null;
			try {
				HSSFSheet aSheet = workbook.createSheet();
				for(int j = 0; j < _cells.size(); j++) {
					HSSFRow aRow = aSheet.createRow(j);
					List<String> cells = _cells.get(j);
					for(int i=0;i<cells.size();i++){
						@SuppressWarnings("deprecation")
						HSSFCell aRell = aRow.createCell((short)i);
						aRell.setCellType(HSSFCell.CELL_TYPE_STRING);
						aRell.setCellValue(new HSSFRichTextString(cells.get(i)));
					}
				}
				
				out = outstreamByPath(filePath);
				workbook.write(out);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				out.close();
			}
		} else if ("xlsx".equals(extension)) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			FileOutputStream  out = null;
			try {
				XSSFSheet aSheet = workbook.createSheet();
				for(int j = 0; j < _cells.size(); j++) {
					XSSFRow aRow = aSheet.createRow(j);
					List<String> cells = _cells.get(j);
					for(int i=0;i<cells.size();i++){
						XSSFCell aRell = aRow.createCell((short)i);
						aRell.setCellType(XSSFCell.CELL_TYPE_STRING);
						aRell.setCellValue(new XSSFRichTextString(cells.get(i)));
					}
				}
				out = outstreamByPath(filePath);
				workbook.write(out);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				out.close();
			}
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	private static FileOutputStream outstreamByPath(String filePath) throws IOException{
		File file = new File(filePath);
		if(!file.exists()){
			file.createNewFile();
		}
		return new FileOutputStream(file);
	}
	
	/**
	 * 默认读取第一个空间
	 * @param file
	 * @return
	 * @throws IOException
	 * 创建人：  fming
	 * 创建时间：2012-6-27  上午10:18:54
	 */
	public static List<List<Object>> readExcel(File file) throws IOException {
		return readExcel(file, "");
	}

	public static List<List<Object>> readExcel(File file, String sheetName) throws IOException {
		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(file, sheetName);
		} else if ("xlsx".equals(extension)) {
			return read2007Excel(file, sheetName);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	
	/**
	 * 根据index读取excel文件
	 * @param file
	 * @param index
	 * @return
	 * @throws IOException
	 * 创建人：  fming
	 * 创建时间：2012-12-18  上午10:27:14
	 */
	public static List<List<Object>> readExcel(File file, int index) throws IOException {
		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
			String sheetName = hwb.getSheetName(index);
			return read2003Excel(file, sheetName);
		} else if ("xlsx".equals(extension)) {
			XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
			String sheetName = xwb.getSheetName(index);
			return read2007Excel(file, sheetName);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	
	public static List<List<Object>> readExcel(String fileName, InputStream inputStream, int index) throws IOException {
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			HSSFWorkbook hwb = new HSSFWorkbook(inputStream);
			String sheetName = hwb.getSheetName(index);
			return process2003Excel(hwb, sheetName);
		} else if ("xlsx".equals(extension)) {
			XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
			String sheetName = xwb.getSheetName(index);
			return read2007Excel(xwb, sheetName);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	
	public static int getNumberSheet(String fileName, InputStream inputStream) throws IOException {
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			HSSFWorkbook hwb = new HSSFWorkbook(inputStream);
			return hwb.getNumberOfSheets();
		} else if ("xlsx".equals(extension)) {
			XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
			return xwb.getNumberOfSheets();
		}
		return 0;
	}
	
	/**
	 * 读取 office 2003 excel
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static List<List<Object>> read2003Excel(File file, String sheetName)
			throws IOException {
		HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
		return process2003Excel(hwb, sheetName);
	}
	
	private static List<List<Object>> process2003Excel(HSSFWorkbook hwb, String sheetName) {
		List<List<Object>> list = new LinkedList<List<Object>>();
		HSSFSheet sheet = hwb.getSheetAt(0);
		if(StringUtils.isNotBlank(sheetName)) {
			sheet = hwb.getSheet(sheetName);
		}
		Object value = null;
		HSSFRow row = null;
		HSSFCell cell = null;

		for (int i = 0; i <= sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = 0; j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					linked.add("");
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// 格式化 number String
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());
					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());
					} else {
						value = sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					value = cell.getBooleanCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					value = "";
					break;
				default:
					value = cell.toString();
				}
//				if (value == null || "".equals(value)) {
//					continue;
//				}
				linked.add(value);

			}
			list.add(linked);
		}

		return list;
	}

	/**
	 * 读取Office 2007 excel
	 * */
	private static List<List<Object>> read2007Excel(File file, String sheetName)
			throws IOException {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		return read2007Excel(xwb, sheetName);
	}

	private static List<List<Object>> read2007Excel(XSSFWorkbook xwb, String sheetName) {
		List<List<Object>> list = new LinkedList<List<Object>>();
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		if(StringUtils.isNotBlank(sheetName)) {
			sheet = xwb.getSheet(sheetName);
		}
		Object value = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		for (int i = 0; i <= sheet
				.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = 0; j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					linked.add("");
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// 格式化 number String
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串

				switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if ("@".equals(cell.getCellStyle().getDataFormatString())) {
							value = df.format(cell.getNumericCellValue());
						} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
							value = df.format(cell.getNumericCellValue());
						} else {
							value = sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						value = cell.getBooleanCellValue();
						break;
					case Cell.CELL_TYPE_BLANK:
						value = "";
						break;
					default:
						value = cell.toString();
				}
//						if (value == null || "".equals(value)) {
//							continue;
//						}
				linked.add(value);
			}
			list.add(linked);
		}
		return list;
	}
	
	public static void main(String[] args) throws Exception{
		
		String path = "C:\\Users\\guopeng\\Desktop\\Amana J20140609(1).xlsx";
		List<List<Object>> list = readExcel(new File(path));
		
		for(List<Object> subList : list){
			for(Object obj : subList){
				System.out.println(String.valueOf(obj));
			}
		}
		
	}
}