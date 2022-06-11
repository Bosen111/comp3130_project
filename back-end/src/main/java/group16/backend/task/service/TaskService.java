package group16.backend.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group16.backend.task.entity.TaskModel;
import group16.backend.task.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskModel createTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public TaskModel findTaskByID(Long taskId) {

        TaskModel taskModel = null;

        Optional<TaskModel> optionalTaskModel = taskRepository.findById(taskId);
        if(optionalTaskModel.isPresent()) {
            taskModel = optionalTaskModel.get();
        }

        return taskModel;

    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
    
}
