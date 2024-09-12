package alekseev.excelparser.controller;

import alekseev.excelparser.dto.RequestDto;
import alekseev.excelparser.util.ExcelConnection;
import alekseev.excelparser.util.ExcelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/api")
public class ExcelController {
    @PostMapping("/parse")
    public void parse(@RequestBody RequestDto requestDto){
        ExcelMapper.getUserList(Objects.requireNonNull(ExcelConnection.loadFile(requestDto.getUrl())));
    }
}
