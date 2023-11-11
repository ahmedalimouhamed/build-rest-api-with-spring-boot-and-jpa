package zerzif.rest.response;

import lombok.Getter;
import lombok.Setter;
import zerzif.rest.model.Department;

import java.util.List;

@Setter
@Getter
public class EmployeeResponse {
    private long id;
    private String name;
    private List<String> department;
}
