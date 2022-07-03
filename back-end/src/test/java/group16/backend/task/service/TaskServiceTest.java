package group16.backend.task.service;

import com.sun.jdi.LongValue;
import group16.backend.task.entity.TaskModel;
import group16.backend.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {


    private TaskRepository taskRepository = new TaskRepository() {
        @Override
        public List<TaskModel> findAll() {
            return null;
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


    private TaskService taskService = new TaskService();

    @Test
    void createTask() {
        TaskModel task = new TaskModel();
        task.setTaskName("test");
        long i = Long.valueOf(12345678910L);
        task.setId(i);
        taskService.taskRepository = taskRepository;
        TaskModel savedTask = taskService.createTask(task);
        assertNotNull(savedTask);
    }

    @Test
    void findTaskByID() {
        TaskModel task = new TaskModel();
        task.setTaskName("test");
        long i = Long.valueOf(12345678910L);
        task.setId(i);
        taskService.taskRepository = taskRepository;
        taskService.createTask(task);
        TaskModel tm = new TaskModel();
        tm.setTaskName("test");
        tm.setId(i);
        assertEquals(tm.getTaskName(), taskService.findTaskByID(i).getTaskName());

    }

    @Test
    void deleteTask() {
        taskService.deleteTask(Long.valueOf(12345678910L));

        assertNull(taskService.findTaskByID(Long.valueOf(12345678910L)));
    }
}