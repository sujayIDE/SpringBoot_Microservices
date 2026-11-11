package in.ashokit.service;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean registerUser(User user)
    {
        User isRegister=userRepository.save(user);
        if(isRegister.getUser_id()!=null)
        {
            return true;
        }else{
            return false;
        }
    }

}
