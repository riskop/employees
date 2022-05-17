package microservices.training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HelloIT {

    @Autowired
    HelloController helloController;

    @Test
    void controllerTest() {
        String message = helloController.sayHello();

        assertThat(message).startsWith("hello");
    }

}
