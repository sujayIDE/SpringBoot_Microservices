package in.ashokit.runner;

import in.ashokit.entity.StudentEntity;
import in.ashokit.entity.UniversityEntity;
import in.ashokit.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveUniversity();
    }

    private void saveUniversity(){
        UniversityEntity universityEntity=new UniversityEntity();
        universityEntity.setUniversity_Name("SPPU");
        universityEntity.setUniversity_Location("Pune");

        StudentEntity studentEntit1=new StudentEntity();
        studentEntit1.setStudent_Name("Sujay");
        studentEntit1.setCourse_Name("MCA");

        StudentEntity studentEntity2=new StudentEntity();
        studentEntity2.setStudent_Name("Ajay");
        studentEntity2.setCourse_Name("MSc");

        List<StudentEntity> studentEntityList=List.of(studentEntit1,studentEntity2);
        universityEntity.setStudentEntityList(studentEntityList);

        universityRepository.save(universityEntity);
    }

}
