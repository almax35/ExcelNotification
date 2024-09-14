package alekseev.excelparser.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelConnection {
    public static XSSFWorkbook loadFile(String url) {
        try {
            FileInputStream file = new FileInputStream(url);
            return new XSSFWorkbook(file);
        } catch (Exception e) {
            return null;
        }
    }
}
