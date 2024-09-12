package alekseev.excelparser.dto;

import alekseev.excelparser.entity.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private UserGroup userGroup;
}
