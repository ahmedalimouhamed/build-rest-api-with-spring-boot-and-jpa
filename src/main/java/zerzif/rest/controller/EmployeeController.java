package zerzif.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerzif.rest.model.Department;
import zerzif.rest.model.Employee;
import zerzif.rest.repository.DepartmentRepository;
import zerzif.rest.repository.EmployeeRepository;
import zerzif.rest.request.EmployeeRequest;
import zerzif.rest.service.EmployeeService;

import java.util.List;

@RestController //@Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") final long employeeId){
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody final EmployeeRequest request){
        Department dep = new Department();
        dep.setName(request.getDepartment());
        departmentRepository.save(dep);
        Employee employee = new Employee(request);
        employee.setDepartment(dep);
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") final Long employeeId, @RequestBody final Employee employee){
        employee.setId(employeeId);
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("employeeId") final Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/filter/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentName(@PathVariable String name){
        //return new ResponseEntity<>(employeeRepository.findByDepartmentName(name), HttpStatus.OK);
        return new ResponseEntity<>(employeeRepository.getEmployeesByDepartmentName(name), HttpStatus.OK);
    }
}
