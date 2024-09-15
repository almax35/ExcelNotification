package alekseev.notificator.service;

import alekseev.notificator.dto.UserDto;
import alekseev.notificator.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UsersConsumer {
    private final MailSenderService mailSenderService;

    @KafkaListener(topics = "users", groupId = "users_group")
    public void listenUsers(String users){
        ArrayList<UserDto> userList = UserMapper.parseToUserDto(users);
        mailSenderService.sendEmails(userList);
    }
}
