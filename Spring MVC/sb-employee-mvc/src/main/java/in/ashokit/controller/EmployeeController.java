package in.ashokit.controller;

import in.ashokit.entity.EmployeeEntity;
import in.ashokit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String getIndexPage(){
        return  "redirect:/index.html";
    }

    @PostMapping("/add")
    public String handleAddEmployee(@ModelAttribute EmployeeEntity employeeEntity)
    {
         employeeService.saveEmployee(employeeEntity);

    }
}
