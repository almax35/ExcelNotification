package alekseev.notificator.controller;

import alekseev.notificator.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class NotificatorController {

    private final MailSenderService mailSender;
    @GetMapping("/sendEmail")
    public ResponseEntity<String> send(){
        mailSender.sendEmail("almaximys@yandex.ru","hi","hi");
        return ResponseEntity.ok("отправлено");
    }
}
