package group16.backend.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group16.backend.task.entity.TaskModel;
import group16.backend.task.service.TaskService;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskService taskService;

    public UserModel signUpUser(UserModel userModel) {

        //todo: check if the email already exists
        // if(false) {
        //     throw new Exception("User with this email already exists.");
        // }
        //check lab code for how to throw to front end

        return userRepository.save(userModel);

    }

    public UserModel logInUser(String userEmail, String userPassword) {
        
        Optional<UserModel> user = userRepository.findByEmail(userEmail);

        if(user.isPresent()){
            UserModel userModel = user.get();
            //check password
            //create session???????
            //jwt token
            return userModel;
        }
        else {
            return null;
        }
        
    }

    public UserModel updateTask(Long userId, Long taskId) {

        UserModel updatedUser = null;
        Optional<UserModel> user = null;

        try {

            user = userRepository.findById(userId);
            if(user.isPresent()) {

                UserModel userModel = user.get();
                TaskModel taskModel = taskService.findTaskByID(taskId);

                List<TaskModel> tasks = userModel.getTasks();
                if(tasks == null) {
                    tasks = new ArrayList<>();
                }
                tasks.add(taskModel);
                userModel.setTasks(tasks);

                updatedUser = userRepository.save(userModel);

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return updatedUser;
    }

    public UserModel updatePassword(String email, String secAnswer, String newPassword){

        UserModel updatedUser = null;
        Optional<UserModel> user = null;

        try{
            user = userRepository.findByEmail(email);
            if(user.isPresent()) {
                
                UserModel userModel = user.get();

                if(userModel.getSecurityAnswer().equals(secAnswer)){
                    userModel.setPassword(newPassword);
                    updatedUser = userRepository.save(userModel);
                }

            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return updatedUser;
    }

    public List<UserModel> getAllUsers() {

        return userRepository.findAll();
    }
    
}
