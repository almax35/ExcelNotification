package alekseev.excelparser.service;

import alekseev.excelparser.dto.UserDto;
import alekseev.excelparser.repository.UserRepository;
import alekseev.excelparser.util.ExcelConnection;
import alekseev.excelparser.util.ExcelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExcelService {
    private final UserRepository userRepository;

    public ArrayList<UserDto> saveUserFromExcel(String url){
        ArrayList<UserDto> users = ExcelMapper.getUserList(Objects.requireNonNull(ExcelConnection.loadFile(url)));
        userRepository.saveAll(users);
        return users;
    }

}
