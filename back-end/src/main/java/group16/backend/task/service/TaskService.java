package group16.backend.task.service;

import java.util.List;
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

    public TaskModel updateTaskStatus(Long taskId, String newStatus) {

        TaskModel updatedTask = null;
        Optional<TaskModel> task = null;

        try {
            task = taskRepository.findById(taskId);
            if(task.isPresent()) {
                TaskModel taskModel = task.get();

                taskModel.setStatus(newStatus);

                updatedTask = taskRepository.save(taskModel);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return updatedTask;
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<TaskModel> getAllTasks() {

        return taskRepository.findAll();
    }
    
}
