package in.ashokit.service;

import in.ashokit.entity.EmployeeEntity;
import in.ashokit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean saveEmployee(EmployeeEntity employeeEntity)
    {
        EmployeeEntity isAdd= employeeRepository.save(employeeEntity);
        if(isAdd.getEmpId()!=null)
        {
            return true;
        }
        return false;
    }
}
