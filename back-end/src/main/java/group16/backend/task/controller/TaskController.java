package group16.backend.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group16.backend.task.entity.TaskModel;
import group16.backend.task.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("/save")
    public TaskModel createTask(@RequestBody TaskModel taskModel) {

        return taskService.createTask(taskModel);

    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @GetMapping("/getById/{taskId}")
    @CrossOrigin(origins = {"http://localhost:3000"})
    public TaskModel getTaskById(@PathVariable Long taskId){
        return taskService.findTaskByID(taskId);
    }

    @GetMapping("/getAll")
    @CrossOrigin(origins = {"http://localhost:3000"})
    public List<TaskModel> getAllTasks() {
        return taskService.getAllTasks();
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("/setStatus/{taskId}")
    public TaskModel updateTaskStatus(@PathVariable Long taskId, @RequestBody String newStatus){ return taskService.updateTaskStatus(taskId, newStatus); }
    
}
