package in.ashokit.repository;

import in.ashokit.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //optional
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //findby approach
    List<Employee> findByDepartment(String department);

    @Query(value = "select e from Employee e where e.sal between ?1 and ?2", nativeQuery = false)
    List<Employee> fetchEmployeeWithSalBetween(double min,double max);

    @Query(value = "select e from Employee e where e.department= :department or e.sal> :sal")
    List<Employee> fetchEmployeeWithDeptOrSal(@Param("department") String department,@Param("sal") double sal);

    @Query(value = "delete from employee where sal>?", nativeQuery = true)
    @Modifying
    @Transactional
    int deleteBySalGreaterThan(double sal);

    List<Employee> fetchAllEmployees();
}
