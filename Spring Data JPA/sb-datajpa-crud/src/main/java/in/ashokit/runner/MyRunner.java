package in.ashokit.runner;

import in.ashokit.entity.Employee;
import in.ashokit.entity.EmployeeStatus;
import in.ashokit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee employee=new Employee(101,"Sujay",45000.0,"IT", EmployeeStatus.ACTIVE);
        save(employee);
    }

    private void save(Employee employee)
    {
        employeeRepository.save(employee);
    }
}
