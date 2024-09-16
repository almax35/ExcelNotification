package alekseev.notificator.controller;

import alekseev.notificator.dto.EmailRequestDto;
import alekseev.notificator.dto.TypeRequestDto;
import alekseev.notificator.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NotificatorController {

    private final MailSenderService mailSender;
    @PostMapping("/sendEmail")
    public ResponseEntity<String> send(@RequestBody EmailRequestDto requestDto){
        mailSender.sendEmail(requestDto.getEmail(),requestDto.getSubject(),requestDto.getText());
        return ResponseEntity.ok("отправлено");
    }
    @PostMapping("/sendByType")
    public ResponseEntity<String> sendByType(@RequestBody TypeRequestDto typeRequestDto){
        System.out.println(typeRequestDto.getType());
        mailSender.sendEmailsByType(typeRequestDto.getType());
        return ResponseEntity.ok("отправлено по типу");
    }

}
