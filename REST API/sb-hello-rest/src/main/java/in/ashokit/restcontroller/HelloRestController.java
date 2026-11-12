package in.ashokit.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/hello/{username}/{age}")
    public String sayHello(@PathVariable String username, @PathVariable int age)
    {
        return "Hello "+username+" "+age;
    }
}
