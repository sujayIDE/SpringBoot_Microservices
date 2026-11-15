package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "course_table")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    private String course_name;
}
