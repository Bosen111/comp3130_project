package group16.backend.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        Optional<UserModel> user = userRepository.findByEmail(userModel.getEmail());

        if(user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exists");
        }

        return userRepository.save(userModel);

    }

    public UserModel logInUser(String userEmail, String userPassword) {
        
        Optional<UserModel> user = userRepository.findByEmail(userEmail);

        if(user.isPresent()){
            UserModel userModel = user.get();

            if(userModel.getPassword().equals(userPassword)){
                return userModel;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Password");
            }

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this Email doesn't exist");
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

    public UserModel updatePassword(String email, String secAnswer, String newPassword) throws ResponseStatusException{

        UserModel updatedUser = null;
        Optional<UserModel> user = null;

        user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            
            UserModel userModel = user.get();

            if(userModel.getSecurityAnswer().equals(secAnswer)){
                userModel.setPassword(newPassword);
                updatedUser = userRepository.save(userModel);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Security Answer");
            }

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with this email");
        }
        return updatedUser;
    }

    public List<UserModel> getAllUsers() {

        return userRepository.findAll();
    }
    
}
