package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getExcelData(String filePath,String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        Object[][] data= new Object[rows-1][cols];
        for (int currentCell = 1; currentCell < rows; currentCell++) {  // Start from row 1, skipping the header
            Row row = sheet.getRow(currentCell);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                data[currentCell - 1][j] = cell.toString();  // Convert cell value to string
            }
        }
        workbook.close();
        fis.close();
        return data;


    }
}
