package zerzif.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerzif.rest.model.Employee;
import zerzif.rest.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController //@Controller + @ResponseBody
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return appName+" "+appVersion;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameOrLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<>(employeeService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameContaining")
    public ResponseEntity<List<Employee>> getEmployeesByNameContaining(@RequestParam String keyword){
        return new ResponseEntity<>(employeeService.getEmployeesByNameContaining(keyword), HttpStatus.OK);
    }
/*
    @GetMapping("/employeesList")
    public List<Employee> getEmployeesList(){
        return employeeService.getEmployees();
    }
*/
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") final long employeeId){
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody final Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable("employeeId") final Long employeeId, @RequestBody final Employee employee){
        employee.setId(employeeId);
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("employeeId") final Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/employees/deleteByName/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
        return new ResponseEntity<String>(employeeService.deleteEmployeeByName(name)+" No of row deleted", HttpStatus.OK);
    }
}
