package alekseev.notificator.controller;

import alekseev.notificator.dto.RequestDto;
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
    public ResponseEntity<String> send(@RequestBody RequestDto requestDto){
        mailSender.sendEmail(requestDto.getEmail(),requestDto.getSubject(),requestDto.getText());
        return ResponseEntity.ok("отправлено");
    }

}
