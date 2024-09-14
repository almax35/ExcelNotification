package alekseev.excelparser.repository;

import alekseev.excelparser.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<UserDto> userDtoList){
        jdbcTemplate.batchUpdate("INSERT INTO users (name, surname, email, type) values (?,?,?,?) ON CONFLICT DO NOTHING",
                userDtoList,
                100,
                (PreparedStatement ps, UserDto userDto) -> {
                    ps.setString(1,userDto.getName());
                    ps.setString(2,userDto.getSurname());
                    ps.setString(3, userDto.getEmail());
                    ps.setString(4,userDto.getType());
                });
    }
}
