package edu.miu.ElectronicHealthRecord;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class ElectronicHealthRecordApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ElectronicHealthRecordApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception { }
}
