package microservices.training.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = EmployeesController.class)
public class EmployeesControllerWebMvcIT {

    @MockBean
    EmployeesService employeesService;

    // ez nem megy
    //@Autowired
    //EmployeeMapper employeeMapper;

    @Autowired
    MockMvc mockMvc; // ez piros az IDEA mban, nem tudom miert? "Could not autowire, no beans of mockmvc type found". Ugyanakkor fut a teszt OK

    @Test
    public void testListEmployees() throws Exception {
        when(employeesService.listEmployees(any())).thenReturn(
                List.of(
//                        employeeMapper.toDto(new Employee(1L, "John Doe")),
//                                employeeMapper.toDto(new Employee(1L, "Jill Doe"))
                        new EmployeeDto(1L, "John Doe"),
                        new EmployeeDto(2L, "Jill Doe")
                        ));

        mockMvc.perform(get("/api/employees"))
                //.andDo(print())
                .andExpect(status().isOk())
        // az alabbi nem megy
                .andExpect(jsonPath("$[0].name", equalTo("John Doe")))
        ;
    }
}
