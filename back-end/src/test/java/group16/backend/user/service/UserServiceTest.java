package group16.backend.user.service;

import group16.backend.task.entity.TaskModel;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;
import group16.backend.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    @Autowired
    private UserRepository userRepository = new UserRepository() {
        @Override
        public Optional<UserModel> findByEmail(String email) {
            return Optional.empty();
        }

        @Override
        public List<UserModel> findAll() {
            return null;
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



    @Mock
    @Autowired
    TaskService taskService = new TaskService();

    @InjectMocks
    private UserService userService = new UserService();

    @Test
    void signUpUser() {
        UserModel um = new UserModel("Name","email","123456","check");
        userService.userRepository = userRepository;
        UserModel savedModel = userService.signUpUser(um);
        assertNotNull(savedModel);
    }

    @Test
    void logInUser() {
        UserModel um = new UserModel();
        um.setEmail("796@gmail.com");
        um.setPassword("8967");


        /*List<TaskModel> tasks = new ArrayList<>();
        TaskModel tm = new TaskModel("test");
        tm.setId(Long.valueOf(2234567892L));
        taskService.createTask(tm);
        tasks.add(tm);
        um.setTasks(tasks);
        userService.signUpUser(um);

        UserModel um2 = new UserModel();
        um2.setEmail("796@gmail.com");
        um2.setName("796");
        um2.setId(Long.valueOf(123456789L));
        um2.setPassword("8967");
        um2.setSecurityAnswer("cars");
        um2.setTasks(tasks);

        Mockito.when(userRepository.findByEmail(um.getEmail())).thenReturn(Optional.of(um));
        assertEquals(um2,userService.logInUser("796@gmail.com","8967"));*/
    }

    @Test
    void updateTask() {
        UserModel um = new UserModel();
        um.setEmail("1234@gmail.com");
        um.setName("12354");
        um.setId(Long.valueOf(12345678910L));
        um.setPassword("123456");
        um.setSecurityAnswer("cars");

        List<TaskModel> tasks = new ArrayList<>();
        TaskModel tm = new TaskModel("test");
        tm.setId(Long.valueOf(1234567892L));
        taskService.createTask(tm);
        tasks.add(tm);
        um.setTasks(tasks);
        userService.signUpUser(um);


        UserModel um2 = new UserModel();
        um2.setEmail("1234@gmail.com");
        um2.setName("12354");
        um2.setId(Long.valueOf(12345678910L));
        um2.setPassword("123456");
        um2.setSecurityAnswer("cars");

        List<TaskModel> tasks2 = new ArrayList<>();
        TaskModel tm2 = new TaskModel("test2");
        tm2.setId(Long.valueOf(1234124L));
        taskService.createTask(tm2);
        tasks2.add(tm2);
        um2.setTasks(tasks2);

        Mockito.when(taskService.findTaskByID(tm.getId())).thenReturn(tm);
        Mockito.when(userRepository.save(um)).thenReturn(um);

        assertEquals(um2,userService.updateTask(Long.valueOf(12345678910L),Long.valueOf(1234124L)));
    }


    @Test
    void updatePassword() {
        UserModel um = new UserModel();
        um.setEmail("1234@gmail.com");
        um.setName("12354");
        um.setId(Long.valueOf(12345678910L));
        um.setPassword("123456");
        um.setSecurityAnswer("cars");

        List<TaskModel> tasks = new ArrayList<>();
        TaskModel tm = new TaskModel("test");
        tm.setId(Long.valueOf(1234567892L));
        taskService.createTask(tm);
        tasks.add(tm);
        um.setTasks(tasks);
        userService.signUpUser(um);


        UserModel um2 = new UserModel();
        um2.setEmail("1234@gmail.com");
        um2.setName("12354");
        um2.setId(Long.valueOf(12345678910L));
        um2.setPassword("654321");
        um2.setSecurityAnswer("cars");
        um2.setTasks(tasks);

        Mockito.when(userRepository.findByEmail(um.getEmail())).thenReturn(Optional.of(um));
        Mockito.when(userRepository.save(um)).thenReturn(um);
        assertEquals(um2,userService.updatePassword(um.getEmail(),um.getSecurityAnswer(),"654321"));
    }

    @Test
    void testGetAllUsers() {
        UserModel um = new UserModel();
        um.setEmail("1234@gmail.com");
        um.setName("12354");
        um.setId(Long.valueOf(12345678910L));
        um.setPassword("123456");
        um.setSecurityAnswer("cars");

        List<TaskModel> tasks = new ArrayList<>();
        TaskModel tm = new TaskModel("test");
        tm.setId(Long.valueOf(1234567892L));
        taskService.createTask(tm);
        tasks.add(tm);
        um.setTasks(tasks);
        userService.signUpUser(um);
        assertEquals(tasks,userService.getAllUsers());
    }
}