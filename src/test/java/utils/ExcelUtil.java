package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtil {

    private static Map<String, List<String>> credentials = new HashMap<>();

    private ExcelUtil() {
    }

    static {
        XSSFWorkbook xssfworkbook = null;
        try {
            xssfworkbook = new XSSFWorkbook("C:\\Users\\Harsha\\canada_automation_prep\\busyQA_jan_mavenProject\\src\\test\\resources\\testdata.xlsx");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        XSSFSheet sheet = xssfworkbook.getSheet("credentials");

        int noOfRows = sheet.getLastRowNum();
        List<String> usernames = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        for (int i = 1; i <= noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            usernames.add(row.getCell(0).getStringCellValue());
            passwords.add(row.getCell(1).getStringCellValue());
        }

        credentials.put("usernames", usernames);
        credentials.put("passwords", passwords);
    }

    public static Map<String, List<String>> getCredentials() {
        return credentials;
    }
}