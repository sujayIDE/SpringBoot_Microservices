package in.ashokit.runner;

import in.ashokit.entity.Employee;
import in.ashokit.entity.EmployeeStatus;
import in.ashokit.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee emp1 = new Employee(101, "Ajay", 45000.0, "IT", EmployeeStatus.ACTIVE);
        Employee emp2 = new Employee(102, "Rahul", 50000.0, "HR", EmployeeStatus.ACTIVE);
        Employee emp3 = new Employee(103, "Sujay", 55000.0, "IT", EmployeeStatus.ACTIVE);
        Employee emp4 = new Employee(104, "Priya", 60000.0, "Finance", EmployeeStatus.ACTIVE);
        Employee emp5 = new Employee(105, "Sneha", 40000.0, "HR", EmployeeStatus.ACTIVE);

        save(emp1);
        save(emp2);
        save(emp3);
        save(emp4);
        save(emp5);

        System.out.println("============Display=============");
        display();

        System.out.println("==============Find by Id==================");
        getEmployeeById(101);

        System.out.println("===============Delete by Id================");
        deleteEmployeeById(101);

        System.out.println("===============Find by department=================");
        getEmployeeByDepartment("HR ");

        System.out.println("===========Get employee between range==========");
        getEmployeesBetweenSal(40000,55000);

        System.out.println("=========Get employee with department or sal===========");
        getEmployeeWithDepartmentOrSal("HR",45000.0);

        System.out.println("========deleteBySalGreaterThan===============");
        deleteEmployeeBySalGreaterThan(55000);

        System.out.println("==========fetchAll================");
        fetchAllEmployees();
    }

    private void fetchAllEmployees() {
        for (Employee employee : employeeRepository.fetchAllEmployees()) {
            System.out.println(employee);
        }

    }

    private void save(Employee employee)
    {
        employeeRepository.save(employee);
    }

    private void display() {
        List<Employee> employeeList = employeeRepository.findAll();
        employeeList.forEach(System.out::println);
    }

    private void getEmployeeById(int empno)
    {
        Optional<Employee> emp=employeeRepository.findById(empno);
        if(emp.isPresent()){
            Employee employee = emp.get();
            System.out.println(employee);
        }
    }

    private void deleteEmployeeById(int empno){
        employeeRepository.deleteById(empno);
        System.out.println("Employee deleted successfully....");
    }

    private void getEmployeeByDepartment(String department)
    {
        List<Employee> byDepartment = employeeRepository.findByDepartment(department);
        byDepartment.forEach(System.out::println);
    }

    private void getEmployeesBetweenSal(int min,int max){
        List<Employee> employees= employeeRepository.fetchEmployeeWithSalBetween(min,max);
        employees.forEach(System.out::println);
    }

    private void getEmployeeWithDepartmentOrSal(String department,double sal)
    {
        List<Employee> employees=employeeRepository.fetchEmployeeWithDeptOrSal(department,sal);
        employees.forEach(System.out::println);
    }
    
    private void deleteEmployeeBySalGreaterThan(double sal){
        int i = employeeRepository.deleteBySalGreaterThan(sal);
        System.out.println(i+" rows deleted...");
    }
}
