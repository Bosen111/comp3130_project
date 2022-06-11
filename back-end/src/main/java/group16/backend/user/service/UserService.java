package group16.backend.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel signUpUser(UserModel userModel) {

        return userRepository.save(userModel);

    }
    
}
