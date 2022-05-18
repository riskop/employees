package microservices.training.employees;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class EmployeeNotFoundException extends AbstractThrowableProblem {

    public EmployeeNotFoundException(long id) {
        super(URI.create("employees/employee-not-found"),
                "not found",
                Status.NOT_FOUND,
                "employee with id " + id + " not found");
    }
}
