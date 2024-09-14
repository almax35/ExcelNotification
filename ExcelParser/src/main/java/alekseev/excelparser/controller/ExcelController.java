package alekseev.excelparser.controller;

import alekseev.excelparser.dto.RequestDto;
import alekseev.excelparser.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ExcelController {
    private final ExcelService excelService;
    @PostMapping("/parse")
    public ResponseEntity<String> parse(@RequestBody RequestDto requestDto){
        excelService.saveUserFromExcel(requestDto.getUrl());
        return ResponseEntity.ok("Пользователи добавлены");
    }
}
