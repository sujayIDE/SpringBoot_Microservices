package in.ashokit.controller;

import in.ashokit.entity.User;
import in.ashokit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getRegistrationPage(){
       return "redirect:/registration-page.html";
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute User user)
    {
        boolean status = userService.registerUser(user);
        if(status)
        {
            return "redirect:/success-page.html";
        }else{
            return "redirect:/failure-page.html";
        }
    }
}
