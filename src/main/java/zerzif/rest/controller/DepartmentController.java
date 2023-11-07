package zerzif.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zerzif.rest.model.Department;
import zerzif.rest.repository.DepartmentRepository;
import zerzif.rest.response.DepartmentResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<DepartmentResponse> getDepartments(){
        List<Department> deps = departmentRepository.findAll();
        List<DepartmentResponse> list = new ArrayList<>();
        deps.forEach(d -> {
            DepartmentResponse dresponse = new DepartmentResponse();
            dresponse.setDepartmentName(d.getName());
            dresponse.setId(d.getId());
            dresponse.setEmployeeName(d.getEmployee().getName());
            list.add(dresponse);
        });
        return list;
    }
}
