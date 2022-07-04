package group16.backend.user.service;

import group16.backend.task.entity.TaskModel;
import group16.backend.task.repository.TaskRepository;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;
import group16.backend.task.service.TaskService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {


    @Autowired
    private UserRepository userRepository = new UserRepository() {
        @Override
        public Optional<UserModel> findByEmail(String email) {
            UserModel um = new UserModel();
            um.setEmail("796@gmail.com");
            um.setPassword("8967");
            um.setSecurityAnswer("check");
            if (um.getEmail().equals(email)) {
                return Optional.of(um);
            }
            return Optional.empty();
        }

        @Override
        public List<UserModel> findAll() {
            UserModel um = new UserModel();
            um.setEmail("0796@gmail.com");
            um.setPassword("8967");
            UserModel um2 = new UserModel();
            um.setEmail("1796@gmail.com");
            um.setPassword("8967");
            UserModel um3 = new UserModel();
            um.setEmail("2796@gmail.com");
            um.setPassword("8967");
            List<UserModel> userModels = new ArrayList<>();
            userModels.add(um);
            userModels.add(um2);
            userModels.add(um3);
            return userModels;
        }

        @Override
        public List<UserModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<UserModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserModel getOne(Long aLong) {
            return null;
        }

        @Override
        public UserModel getById(Long aLong) {
            return null;
        }

        @Override
        public UserModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserModel> S save(S entity) {
            return entity;
        }

        @Override
        public Optional<UserModel> findById(Long aLong) {
            UserModel um = new UserModel();
            um.setEmail("796@gmail.com");
            um.setPassword("8967");
            um.setId(aLong);
            return Optional.of(um);
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(UserModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends UserModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


    @Autowired
    TaskService taskService = new TaskService(){


        public TaskRepository taskRepository = new TaskRepository() {
            @Override
            public List<TaskModel> findAll() {
                List<TaskModel> l = new ArrayList<>();
                TaskModel task = new TaskModel();
                task.setTaskName("test");
                long i = Long.valueOf(12345678910L);
                task.setId(i);
                l.add(task);
                TaskModel task2 = new TaskModel();
                task2.setTaskName("test");
                long j = Long.valueOf(123456789L);
                task2.setId(j);
                l.add(task2);
                return l;
            }

            @Override
            public List<TaskModel> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<TaskModel> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends TaskModel> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends TaskModel> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends TaskModel> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<TaskModel> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public TaskModel getOne(Long aLong) {
                return null;
            }

            @Override
            public TaskModel getById(Long aLong) {
                return null;
            }

            @Override
            public TaskModel getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends TaskModel> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends TaskModel> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<TaskModel> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends TaskModel> S save(S entity) {
                return entity;
            }

            @Override
            public Optional<TaskModel> findById(Long aLong) {
                TaskModel task = new TaskModel();
                task.setTaskName("test");
                long i = Long.valueOf(12345678910L);
                task.setId(i);
                if(task.getId().equals(aLong)) {
                    return Optional.of(task);
                }
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(TaskModel entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends TaskModel> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends TaskModel> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends TaskModel> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends TaskModel> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends TaskModel> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends TaskModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        public TaskModel createTask(TaskModel taskModel) {
            return this.taskRepository.save(taskModel);
        }

        public TaskModel findTaskByID(Long taskId) {

            TaskModel taskModel = null;

            Optional<TaskModel> optionalTaskModel = this.taskRepository.findById(taskId);
            if(optionalTaskModel.isPresent()) {
                taskModel = optionalTaskModel.get();
            }

            return taskModel;

        }

        public void deleteTask(Long taskId) {
            taskRepository.deleteById(taskId);
        }

        public List<TaskModel> getAllTasks() {

            return taskRepository.findAll();
        }

    };


    private UserService userService = new UserService();

    @Test
    void signUpUser() {
        UserModel um = new UserModel("Name","email","123456","check");
        userService.userRepository = userRepository;
        UserModel savedModel = userService.signUpUser(um);
        assertNotNull(savedModel);
    }

    @Test
    void signUpUserAlreadyExists(){
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        userService.userRepository = userRepository;
        try {
            UserModel savedModel = userService.signUpUser(um);
        }catch (ResponseStatusException e){
            ResponseStatusException x = new ResponseStatusException(HttpStatus.BAD_REQUEST,"User with this email already exists");
            assertEquals(e.getMessage(),x.getMessage());
        }

    }

    @Test
    void logInUser() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        userService.userRepository = userRepository;

        UserModel um2 = userService.logInUser("796@gmail.com","8967");

        assertEquals(um2.getEmail(),um.getEmail());
    }

    @Test
    void logInUserIncorrectPassword() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        userService.userRepository = userRepository;
        try {

            UserModel um2 = userService.logInUser("796@gmail.com", "89672");
        }catch (ResponseStatusException e){
            ResponseStatusException x = new ResponseStatusException(HttpStatus.BAD_REQUEST,"Incorrect Password");
            assertEquals(e.getMessage(),x.getMessage());
        }
    }

    @Test
    void logInUserUserDoesNotExist() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        userService.userRepository = userRepository;
        try {
            UserModel um2 = userService.logInUser("7926@gmail.com", "896722");
        }catch (ResponseStatusException e){
            ResponseStatusException x = new ResponseStatusException(HttpStatus.NOT_FOUND,"User with this Email doesn't exist");
            assertEquals(e.getMessage(),x.getMessage());
        }

    }

    @Test
    void updateTask() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");


        userService.userRepository = userRepository;
        userService.taskService = taskService;

        TaskModel task = new TaskModel();
        task.setTaskName("test");
        long i = Long.valueOf(12345678910L);
        task.setId(i);

        TaskModel savedTask = taskService.createTask(task);

        UserModel um2 = userService.updateTask(um.getId(),task.getId());
        assertEquals(um2.getId(),um.getId());
    }



    @Test
    void updatePassword() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        um.setSecurityAnswer("check");
        userService.userRepository = userRepository;

        UserModel um2 = userService.updatePassword("796@gmail.com","check","6789");

        assertEquals(um2.getEmail(),um.getEmail());
    }

    @Test
    void updatePasswordIncorrectSecurityAnswer() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        um.setSecurityAnswer("check");
        userService.userRepository = userRepository;
        try {
            UserModel um2 = userService.updatePassword("796@gmail.com", "checker", "6789");
        }catch (ResponseStatusException e){

            ResponseStatusException x = new ResponseStatusException(HttpStatus.BAD_REQUEST,"Incorrect Security Answer");
            assertEquals(e.getMessage(),x.getMessage());
        }

    }

    @Test
    void updatePasswordNoUserFound() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");
        um.setSecurityAnswer("check");
        userService.userRepository = userRepository;

        try {
            UserModel um2 = userService.updatePassword("7926@gmail.com", "checker", "6789");
        }catch (ResponseStatusException e){

            ResponseStatusException x = new ResponseStatusException(HttpStatus.NOT_FOUND,"No user found with this email");
            assertEquals(e.getMessage(),x.getMessage());
        }
    }


    @Test
    void testGetAllUsers() {
        UserModel um = new UserModel();
        um.setEmail("0796@gmail.com");
        um.setPassword("8967");
        UserModel um2 = new UserModel();
        um.setEmail("1796@gmail.com");
        um.setPassword("8967");
        UserModel um3 = new UserModel();
        um.setEmail("2796@gmail.com");
        um.setPassword("8967");
        userService.userRepository = userRepository;

        userService.signUpUser(um2);
        userService.signUpUser(um3);

        List<UserModel> userModels = new ArrayList<>();
        userModels.add(um);
        userModels.add(um2);
        userModels.add(um3);

        List<UserModel> checkUserModels = userService.getAllUsers();
        for (int x = 0;x < checkUserModels.size();x++){
            assertEquals(userModels.get(x).getEmail(),checkUserModels.get(x).getEmail());
        }

    }
}