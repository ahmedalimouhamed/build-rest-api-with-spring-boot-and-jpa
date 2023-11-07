package zerzif.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerzif.rest.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
