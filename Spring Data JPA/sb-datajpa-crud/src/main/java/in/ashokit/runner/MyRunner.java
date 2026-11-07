package in.ashokit.runner;

import in.ashokit.entity.Employee;
import in.ashokit.entity.EmployeeStatus;
import in.ashokit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee employee=new Employee(101,"Ajay",45000.0,"IT", EmployeeStatus.ACTIVE);
        save(employee);

        System.out.println("=========================");

        display();
    }

    private void save(Employee employee)
    {
        employeeRepository.save(employee);
    }

    private void display()
    {
       List<Employee> employeeList= employeeRepository.findAll();
       employeeList.forEach(System.out::println);
    }

    private void updateRecord(Employee employee)
    {
        employeeRepository.save(employee);
    }
}
