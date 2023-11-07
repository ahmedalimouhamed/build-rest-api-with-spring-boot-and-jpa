package zerzif.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zerzif.rest.model.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
