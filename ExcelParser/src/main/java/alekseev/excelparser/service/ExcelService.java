package alekseev.excelparser.service;

import alekseev.excelparser.dto.UserDto;
import alekseev.excelparser.repository.UserRepository;
import alekseev.excelparser.util.ExcelConnection;
import alekseev.excelparser.util.ExcelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExcelService {
    private final UserRepository userRepository;

    public void saveUserFromExcel(String url){
        List<UserDto> users = ExcelMapper.getUserList(Objects.requireNonNull(ExcelConnection.loadFile(url)));
        userRepository.saveAll(users);
    }

}
