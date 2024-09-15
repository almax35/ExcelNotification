package alekseev.excelparser.service;

import alekseev.excelparser.dto.UserDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserSendService {

    private final KafkaTemplate<String, ArrayList<UserDto>> kafkaTemplate;

    public UserSendService(KafkaTemplate<String, ArrayList<UserDto>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ArrayList<UserDto> users) {
        kafkaTemplate.send("users", users);
    }

}
