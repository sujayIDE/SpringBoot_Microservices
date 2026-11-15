package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_table")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String student_name;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name="course_id")
            )
    List<Course> courseList=new ArrayList<>();

}
