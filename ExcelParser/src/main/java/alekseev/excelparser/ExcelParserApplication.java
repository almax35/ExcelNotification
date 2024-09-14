package alekseev.excelparser;

import alekseev.excelparser.util.ExcelConnection;
import alekseev.excelparser.util.ExcelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class ExcelParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelParserApplication.class, args);
	}

}
