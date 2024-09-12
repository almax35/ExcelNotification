package alekseev.excelparser.util;

import alekseev.excelparser.dto.UserDto;
import alekseev.excelparser.entity.UserGroup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelMapper {
    public static List<UserDto> getUserList(HSSFWorkbook workbook){
        List<UserDto> userList = new ArrayList<>();
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator rowIter = sheet.rowIterator();
        rowIter.next();
        while (rowIter.hasNext()) {
            HSSFRow row = (HSSFRow) rowIter.next();
            Iterator cellIter = row.cellIterator();
            String name=(String) cellIter.next();
            String surname=(String) cellIter.next();
            String email=(String) cellIter.next();
            UserGroup userGroup=(UserGroup) cellIter.next();
            System.out.println(name+" "+surname+" "+email+" "+userGroup);
            userList.add(new UserDto(name,surname, email,userGroup));
        }
        return userList;
    }
}
