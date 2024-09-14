package alekseev.excelparser.util;

import alekseev.excelparser.dto.UserDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelMapper {
    public static List<UserDto> getUserList(XSSFWorkbook workbook){
        List<UserDto> userList = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIter = sheet.iterator();
        rowIter.next();
        while (rowIter.hasNext()) {
            Row row = rowIter.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            String name=cellIterator.next().getStringCellValue();
            String surname=cellIterator.next().getStringCellValue();
            String email=cellIterator.next().getStringCellValue();
            String type=cellIterator.next().getStringCellValue();
            userList.add(new UserDto(name,surname, email, type));
        }
        return userList;
    }
}
