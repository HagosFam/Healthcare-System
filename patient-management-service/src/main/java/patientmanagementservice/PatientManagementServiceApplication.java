package patientmanagementservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Patient Microservice REST API Documentation",
				description = "Patient Microservice REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Beabkal",
						email = "b3abkal@gmail.com",
						url = "https://github.com/beabkal"
				)
		)
)
public class PatientManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementServiceApplication.class, args);
	}

}
