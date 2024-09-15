package alekseev.notificator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestDto {
    private String email;
    private String subject;
    private String text;
}
