package zerzif.rest.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name="tbl_employee")
@NamedQuery(name="Employee.getAllRecords", query="FROM Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    private String name;

    private String location;
}
