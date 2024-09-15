package alekseev.notificator.service;

import alekseev.notificator.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("excelnotificator@gmail.com");
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
}
