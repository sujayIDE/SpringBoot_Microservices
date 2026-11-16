package in.ashokit.service;

import in.ashokit.entity.UserEntity;
import in.ashokit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public UserEntity updateUser(Integer id,UserEntity userEntity)
    {
        Optional<UserEntity> byId = userRepository.findById(id);
        if(byId.isPresent())
        {
            userEntity.setUserId(id);
            return userRepository.save(userEntity);
        }else{
            return null;
        }
    }

    public UserEntity deleteUSer(Integer id){
        Optional<UserEntity> byId = userRepository.findById(id);
        {
            if(byId.isPresent())
            {
                userRepository.deleteById(id);
                return byId.get();
            }else{
                return null;
            }
        }
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserByEmail(String email)
    {
        return userRepository.findByEmail(email).orElse(null);
    }
}

