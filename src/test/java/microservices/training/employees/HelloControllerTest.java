package microservices.training.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    @Mock
    HelloService helloService;

    @InjectMocks
    HelloController helloController;

    @Test
    void sayHello() {
        when(helloService.sayHello()).thenReturn("mock says hello");

        String message = helloService.sayHello();

        assertThat(message).startsWith("mock");
    }
}