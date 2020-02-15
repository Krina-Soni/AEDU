package AEDU.Utilities;
import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import AEDU.Testcases.Basecase;
import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteFunction extends Basecase {
    public static FileOutputStream outputFile;
    static FileInputStream file;
    static FileInputStream masterFile;

    public static ExtentTest test;

    public ReadWriteFunction(ExtentTest test)
    {
        this.test=test;
    }

    /*

     * readExcel method to read Test Cases,TestData files using Apache POI
     * Libraries
     */

    public static String getCellValue(String path, String sheet, int row, int cell)
            throws EncryptedDocumentException, InvalidFormatException, IOException {

        try {

            file = new FileInputStream(path);
            Workbook workBook = WorkbookFactory.create(file);
            Cell cell1 = workBook.getSheet(sheet).getRow(row).getCell(cell);
            cell1.setCellType(Cell.CELL_TYPE_STRING);
            return cell1.getStringCellValue();
        } catch (Exception e) {

            return "";
        }

    }

    public static int getRowCount(String path,String sheet)
            throws EncryptedDocumentException, InvalidFormatException, IOException {

        try {
            FileInputStream files = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(files);
            return workbook.getSheet(sheet).getLastRowNum();
        } catch (Exception e) {
            return 0;
        }

    }

    public static void writeExcelSheet(String path,String sheet, int row, int cell, String result)
            throws EncryptedDocumentException, InvalidFormatException, IOException {

        file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheets = workbook.getSheet(sheet);
        FileOutputStream output = new FileOutputStream(path);
        sheets.getRow(row).createCell(cell).setCellValue(result);
        workbook.setForceFormulaRecalculation(true);

        workbook.write(output);

        output.close();
    }
}
