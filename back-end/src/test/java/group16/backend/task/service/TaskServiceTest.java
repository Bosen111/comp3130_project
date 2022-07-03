package group16.backend.task.service;

import com.sun.jdi.LongValue;
import group16.backend.task.entity.TaskModel;
import group16.backend.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;

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

class TaskServiceTest {


    private TaskRepository taskRepository = new TaskRepository() {
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
        TaskModel t3 = taskService.findTaskByID(i);
        assertEquals(tm.getTaskName(), t3.getTaskName());

    }

    @Test
    void deleteTask() {
        TaskModel task = new TaskModel();
        task.setTaskName("test");
        long i = Long.valueOf(123456789L);
        task.setId(i);
        taskService.taskRepository = taskRepository;
        taskService.createTask(task);
        taskService.deleteTask(Long.valueOf(123456789L));
        assertNull(taskService.findTaskByID(123456789L));
    }

    @Test
    void getAllTasks(){
        List<TaskModel> q = new ArrayList<>();
        TaskModel task = new TaskModel();
        task.setTaskName("test");
        long i = Long.valueOf(12345678910L);
        task.setId(i);
        q.add(task);
        TaskModel task2 = new TaskModel();
        task2.setTaskName("test");
        long j = Long.valueOf(123456789L);
        task2.setId(j);
        q.add(task2);
        taskService.taskRepository = taskRepository;
        taskService.createTask(task);
        taskService.createTask(task2);
        List<TaskModel> l = taskService.getAllTasks();
        for (int x = 0;x < l.size();x++){
            assertEquals(q.get(x).getId(),l.get(x).getId());
        }
    }
}