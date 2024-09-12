package alekseev.excelparser.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;

public class ExcelConnection {
    public static HSSFWorkbook loadFile(String url) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(url));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            return wb;
        } catch (Exception e) {
            return null;
        }
    }
}
