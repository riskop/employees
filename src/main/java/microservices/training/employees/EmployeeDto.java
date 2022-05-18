package microservices.training.employees;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;

    private String name;

    public EmployeeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EmployeeDto() {
    }
}
