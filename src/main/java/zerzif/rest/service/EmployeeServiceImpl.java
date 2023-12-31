package zerzif.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zerzif.rest.model.Employee;
import zerzif.rest.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    /*
    private static List<Employee> list = new ArrayList<>();

    static {
        Employee e1 = new Employee();
        e1.setName("Ahmed");
        e1.setAge(16);
        e1.setEmail("ahmed@gmail.com");
        e1.setLocation("casablanca");
        e1.setDepartment("IT");

        Employee e2 = new Employee();
        e2.setName("alhassan");
        e2.setAge(19);
        e2.setEmail("hassan@gmail.com");
        e2.setLocation("casablanca");
        e2.setDepartment("IT");

        list.add(e1);
        list.add(e2);
    }

     */

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for id "+employeeId);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        return employeeRepository.save(employee);
    }
}
