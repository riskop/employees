package microservices.training.employees;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEmployeeCommand {

    private String name;
}
