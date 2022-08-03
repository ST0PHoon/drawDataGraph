package kr.ac.kopo.ctc.kopo37;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })	// db 예외처리
public class DrawDataGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrawDataGraphApplication.class, args);
	}

}
