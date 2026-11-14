package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "university_tbl")
@Data
public class UniversityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer university_Id;
    private String university_Name;
    private String university_Location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "universityEntity")
    List<StudentEntity> studentEntityList=new ArrayList<>();
}
