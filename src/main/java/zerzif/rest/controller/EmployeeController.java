package zerzif.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerzif.rest.model.Employee;
import zerzif.rest.repository.EmployeeRepository;
import zerzif.rest.request.EmployeeRequest;

import java.util.ArrayList;
import java.util.List;

@RestController //@Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        //return new ResponseEntity<>(employeeDao.getAll(), HttpStatus.OK);
        return new ResponseEntity<>(employeeRepository.getAllRecords(), HttpStatus.OK);
    }


    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody final EmployeeRequest request){
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setLocation(request.getLocation());
        employee = employeeRepository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


}
