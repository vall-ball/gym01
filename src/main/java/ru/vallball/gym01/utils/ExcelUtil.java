package ru.vallball.gym01.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ru.vallball.gym01.model.Sportsman;
import ru.vallball.gym01.model.TrainingDay;
import ru.vallball.gym01.model.WeekSchedule;

public class ExcelUtil {
/*
	public static HSSFWorkbook createFile() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		return workbook;
	}
	*/
	public static void main(String[] args) throws IOException {
		ExcelUtil util = new ExcelUtil();
		WeekSchedule week = new WeekSchedule();
		Sportsman sportsman = new Sportsman();
		sportsman.setName("Vaso");
		week.setSportsman(sportsman);
		util.writeData(week);
	}
	
	public void writeData(WeekSchedule week) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet= workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Расписание для " + week.getSportsman().getName());
		//HSSFRow row1 = sheet.createRow(1);
		int i = 1;
		for (TrainingDay day : week.getDays()) {
			HSSFRow r = sheet.createRow(i);
			HSSFCell c = r.createCell(0);
			c.setCellValue(day.getDayOfWeek().toString());
			i++;
			
		}
		File file = new File("C:\\Users\\val\\Desktop\\1\\" + week.getSportsman().getName() + ".xls");
		FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);	
        outFile.close();
	}

}
