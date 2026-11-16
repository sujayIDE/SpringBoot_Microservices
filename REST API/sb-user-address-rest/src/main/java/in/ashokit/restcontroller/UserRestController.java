package in.ashokit.restcontroller;

import in.ashokit.entity.UserEntity;
import in.ashokit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity)
    {
        UserEntity saveUser = userService.saveUser(userEntity);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id,@RequestBody UserEntity userEntity)
    {
        UserEntity updateUser = userService.updateUser(id, userEntity);
        if(updateUser!=null)
        {
            return new ResponseEntity<>(updateUser,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updateUser,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserEntity> deleteUserById(@PathVariable Integer id)
    {
        UserEntity deleteUSer = userService.deleteUSer(id);
        if(deleteUSer!=null)
        {
            return new ResponseEntity<>(deleteUSer,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(deleteUSer,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers()
    {
        List<UserEntity> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
}
