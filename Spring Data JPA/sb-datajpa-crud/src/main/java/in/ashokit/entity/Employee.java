package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    private Integer empno;
    private String ename;
    private Double sal;
    private String department;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
}
