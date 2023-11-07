package zerzif.rest.service;

import zerzif.rest.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);
    Employee saveEmployee(Employee employee);

    Employee getEmployee(long employeeId);

    void deleteEmployee(long employeeId);

    Employee updateEmployee(long id, Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByNameContaining(String name);

    List<Employee> getEmployeesByNameOrLocation(String name, String location);
    Integer deleteEmployeeByName(String name);
}
