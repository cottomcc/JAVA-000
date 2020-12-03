package cc.cottom.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.Driver;

@SpringBootApplication
public class BatchInsertTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BatchInsertTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	private Connection getConnect() {
		Driver
	}
}
