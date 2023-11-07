package zerzif.rest.service;

import zerzif.rest.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);

    Employee getEmployee(long employeeId);

    void deleteEmployee(long employeeId);

    Employee updateEmployee(long id, Employee employee);
}
