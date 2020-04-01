package Utilities.ExcelUtilities;

import BaseClass.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class ReadExcelFile {
    static Workbook book;
    static Sheet sheet;
    public static String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/resources/Testdata.xlsx";

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        Object[][] data = new Object[0][];
        try {
            file = new FileInputStream(TEST_DATA_SHEET_PATH);

            book = WorkbookFactory.create(file);

            sheet = book.getSheet(sheetName);
            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i + 1);
                Cell cell = null;
                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    String value;
                    try {
                        //logic to convert mobile numbers into a string without including Decimals
                        value = cell.getRichStringCellValue().toString();
                    } catch (Exception e) {
                        value = ((XSSFCell) cell).getRawValue();
                    }
                    data[i][k] = value;
                    //data[i][k] = sheet.getRow(i + 1).getCell(k).
                }   }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return data;
    }
}
