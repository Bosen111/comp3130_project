package group16.backend.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String completionDate;

    private String status;

    //constructor
    public TaskModel(String taskName, String completionDate, String status) {
        this.taskName = taskName;
        this.completionDate = completionDate;
        this.status = status;
    }

    public TaskModel() {
    }
    
    //Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompletionDate() { return completionDate; }

    public void setCompletionDate(String completionDate) { this.completionDate = completionDate; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
