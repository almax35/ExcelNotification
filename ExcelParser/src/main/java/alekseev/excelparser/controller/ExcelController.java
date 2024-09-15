package alekseev.excelparser.controller;

import alekseev.excelparser.dto.RequestDto;
import alekseev.excelparser.dto.UserDto;
import alekseev.excelparser.service.ExcelService;
import alekseev.excelparser.service.UserSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ExcelController {
    private final ExcelService excelService;
    private final UserSendService userSendService;
    @PostMapping("/parse")
    public ResponseEntity<String> parse(@RequestBody RequestDto requestDto){
        excelService.saveUserFromExcel(requestDto.getUrl());
        return ResponseEntity.ok("Пользователи добавлены");
    }
    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody RequestDto requestDto){
        ArrayList<UserDto> users = excelService.saveUserFromExcel(requestDto.getUrl());
        userSendService.sendMessage(users);
        return ResponseEntity.ok("Пользователи отправлены на сервис рассылки");
    }

}
