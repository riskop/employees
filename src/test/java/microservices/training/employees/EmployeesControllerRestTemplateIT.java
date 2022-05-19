package microservices.training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeesControllerRestTemplateIT {

    @Autowired
    TestRestTemplate template;

    @Test
    void testListEmployees() {
        EmployeeDto employeeDto =
                template.postForObject("/api/employees", new CreateEmployeeCommand("John Doe"), EmployeeDto.class);

        assertEquals();
    }
}
