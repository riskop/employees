package microservices.training.employees;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
//import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class EmployeesService {

    //private final ModelMapper modelMapper;
    private final EmployeeMapper employeeMapper;

    private AtomicLong idGenerator = new AtomicLong();

    private final List<Employee> employees = Collections.synchronizedList(new ArrayList<>(List.of(
            new Employee(idGenerator.incrementAndGet(), "John Doe"),
            new Employee(idGenerator.incrementAndGet(), "Jack Doe")
    )));

//    public EmployeesService(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
    public EmployeesService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDto> listEmployees(Optional<String> prefix) {

        List<Employee> filtered = employees.stream().filter(
                e -> prefix.isEmpty() || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase())
        ).collect(Collectors.toList());

        //Type targetListType = new TypeToken<List<EmployeeDto>>(){}.getType();
        //return modelMapper.map(filtered, targetListType);

        return employeeMapper.toDto(filtered);
    }

    private Employee findEmployeeByIdInternal(Long id) {

        Employee employeeFound = employees.stream().filter(
                e -> e.getId() == id).findFirst().
                orElseThrow(() -> new EmployeeNotFoundException(id));

        return employeeFound;
    }

    public EmployeeDto findEmployeeById(Long id) {
        //return modelMapper.map(findEmployeeByIdInternal(id), EmployeeDto.class);
        return employeeMapper.toDto(findEmployeeByIdInternal(id));
    }

    public EmployeeDto createEmployee(CreateEmployeeCommand createEmployeeCommand) {
        Employee employee = new Employee(idGenerator.incrementAndGet(), createEmployeeCommand.getName());
        employees.add(employee);
        //return modelMapper.map(employee, EmployeeDto.class);
        return null;
    }

    public EmployeeDto updateEmployee(Long id, UpdateEmployeeCommand updateEmployeeCommand) {
        Employee toUpdate = findEmployeeByIdInternal(id);
        toUpdate.setName(updateEmployeeCommand.getName());
        //return modelMapper.map(toUpdate, EmployeeDto.class);
        return null;
    }

    public void deleteEmployee(Long id) {
        Employee toDelete = findEmployeeByIdInternal(id);
        employees.remove(toDelete);
    }
}
