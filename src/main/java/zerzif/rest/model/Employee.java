package zerzif.rest.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import zerzif.rest.request.EmployeeRequest;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name="tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    private String name;

    public Employee(EmployeeRequest employeeRequest) {
        this.name = employeeRequest.getName();
    }
}
