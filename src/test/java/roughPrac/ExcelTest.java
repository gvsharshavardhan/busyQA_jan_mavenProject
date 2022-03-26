package roughPrac;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelTest {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook xssfworkbook = new XSSFWorkbook("C:\\Users\\Harsha\\canada_automation_prep\\busyQA_jan_mavenProject\\src\\test\\resources\\testdata.xlsx");
        XSSFSheet sheet = xssfworkbook.getSheet("credentials");

        int noOfRows = sheet.getLastRowNum();
        for (int i = 1; i <= noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cells; j++) {
                XSSFCell value = row.getCell(j);
                System.out.print(value.getStringCellValue()+ "\t");
            }
            System.out.println();
        }
    }
}