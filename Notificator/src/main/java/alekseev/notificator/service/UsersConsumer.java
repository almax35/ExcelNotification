package alekseev.notificator.service;

import alekseev.notificator.dto.UserDto;
import alekseev.notificator.utils.UserMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UsersConsumer {

    @KafkaListener(topics = "users", groupId = "users_group")
    public ArrayList<UserDto> listenUsers(String users){
        return UserMapper.parseToUserDto(users);
    }
}
