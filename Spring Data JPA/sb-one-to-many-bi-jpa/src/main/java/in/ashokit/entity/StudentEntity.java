package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_tbl")
@Data
public class StudentEntity {
    @Id
    @SequenceGenerator(
            name = "student-generator",
            initialValue = 1001,
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student-generator"
    )
    private Integer student_Id;
    private String student_Name;
    private String course_Name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "University_Id")
    private UniversityEntity universityEntity;
}
