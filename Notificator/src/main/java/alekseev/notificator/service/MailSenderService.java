package alekseev.notificator.service;

import alekseev.notificator.dto.UserDto;
import alekseev.notificator.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class MailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    private final UserService userService;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendEmails(ArrayList<UserDto> users){
        for (UserDto userDto: users){
           sendEmail(userDto.getEmail(),"test mail", "hello,"+userDto.getName()+" "+userDto.getSurname());
        }
    }

    public void sendEmailsByType(String type){
        sendEmails(UserMapper.parseUserToUserDto(userService.getUsersByType(type)));
    }
}
