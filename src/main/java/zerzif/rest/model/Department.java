package zerzif.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    private String name;

//    @OneToOne(mappedBy = "department")
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}
