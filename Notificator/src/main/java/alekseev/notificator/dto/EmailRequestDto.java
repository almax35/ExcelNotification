package alekseev.notificator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailRequestDto {
    private String email;
    private String subject;
    private String text;
}
