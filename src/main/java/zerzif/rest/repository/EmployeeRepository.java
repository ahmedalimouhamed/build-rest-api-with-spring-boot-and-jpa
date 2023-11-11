package zerzif.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zerzif.rest.model.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query(value="select * from tbl_employee", nativeQuery = true)
//    List<Employee> getEmployees();

    @Query(value="insert into tbl_employee(name, location) set values(#{employee.name}, #{employee.location})", nativeQuery = true)
    Employee insertNewEmployees(Employee employee);

    List<Employee> getAllRecords();
}
