package zerzif.rest.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    @NotBlank(message = "Name should not be empty.")
    private String name;

    @Column(name="age")
    private Integer age = 0;

    @Column(name="location")
    private String location;

    @Email(message = "please enter the valid email address.")
    @Column(name="email")
    private String email;

    @NotBlank(message = "Department should not be empty.")
    @Column(name="department")
    private String department;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;
}
