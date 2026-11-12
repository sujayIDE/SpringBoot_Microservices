package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee_tbl")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empName;
    private double salary;
    private String department;
}
