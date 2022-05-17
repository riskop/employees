package microservices.training.employees;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    @Test
    void sayHello() {
        HelloService helloService = new HelloService();
        String message = helloService.sayHello();

        assertThat(message).startsWith("hello");
    }
}