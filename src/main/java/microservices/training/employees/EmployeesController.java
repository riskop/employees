package microservices.training.employees;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public List<EmployeeDto> listEmployee(@RequestParam Optional<String> prefix) {
        return employeesService.listEmployees(prefix);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity findEmployeeById(@PathVariable("id") Long id) {
//        try {
//            return ResponseEntity.ok(employeesService.findEmployeeById(id));
//        }
//        catch (IllegalArgumentException illegalArgumentException) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") Long id) {
        return employeesService.findEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody CreateEmployeeCommand createEmployeeCommand) {
        return employeesService.createEmployee(createEmployeeCommand);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeCommand updateEmployeeCommand) {
        return employeesService.updateEmployee(id, updateEmployeeCommand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee(@PathVariable Long id) {
        employeesService.deleteEmployee(id);
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<Problem> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
//        Problem problem = Problem.builder().withType(URI.create("employee/not-found"))
//                .withTitle("NOT-FOUND")
//                .withStatus(Status.NOT_FOUND)
//                .withDetail(illegalArgumentException.getMessage())
//                .build();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
//                .body(problem);
//    }

}
