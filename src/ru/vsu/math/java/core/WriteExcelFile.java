package ru.vsu.math.java.core;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.vsu.math.java.ui.MainUI;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dima on 05.10.14.
 */
public class WriteExcelFile {

    public static void writeExcelFile(String fileName, List<Table> tableList) throws Exception {
        Workbook workbook = null;

        if(fileName.endsWith("xlsx")){
            workbook = new XSSFWorkbook();
        }else if(fileName.endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            throw new Exception("invalid file name, should be xls or xlsx");
        }

        Sheet sheet = workbook.createSheet("Экспериментальные данные");

        Iterator<Table> iterator = tableList.iterator();

        int rowIndex = 0;
        while(iterator.hasNext()){
            Table table = iterator.next();
            Row row = sheet.createRow(rowIndex++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(table.getId());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(table.getCG1());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(table.getCG2());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(table.getCG3());
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(table.getCG4());
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(table.getCG5());
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(table.getCG6());
            Cell cell7 = row.createCell(7);
            cell7.setCellValue(table.getCG7());
            Cell cell8 = row.createCell(8);
            cell8.setCellValue(table.getCG8());
            Cell cell9 = row.createCell(9);
            cell9.setCellValue(table.getCG9());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println(fileName + " - запись файла завершена.");
    }
}

