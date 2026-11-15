package in.ashokit.runner;

import in.ashokit.entity.Course;
import in.ashokit.entity.Student;
import in.ashokit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        addStudent();
    }
    
    private void addStudent(){
        Student student1=new Student();
        student1.setStudent_name("Rohit");
        
        Student student2=new Student();
        student2.setStudent_name("Ajay");

        Course course1=new Course();
        course1.setCourse_name("Java");
        
        Course course2=new Course();
        course2.setCourse_name("Python");
        
        List<Course> courseList=List.of(course1,course2);
        student1.setCourseList(courseList);

        Student[] students={student1,student2};

        studentRepository.saveAll(List.of(students));
    }
}
