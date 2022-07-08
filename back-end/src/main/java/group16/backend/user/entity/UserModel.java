package group16.backend.user.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import group16.backend.board.BoardModel;
import group16.backend.task.entity.TaskModel;
import group16.backend.workspace.entity.Workspace;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;
    
    private String securityAnswer;
    
    @OneToMany(targetEntity = TaskModel.class)
    @JoinColumn(name = "task_mapping_user")
    private List<TaskModel> tasks;

    @OneToMany(targetEntity = BoardModel.class)
    @JoinColumn(name = "board_mapping_user")
    private List<BoardModel> boards;

    @ManyToMany(mappedBy = "users")
    private List<Workspace> workspaces;

    //Constructor
    public UserModel(String name, String email, String password, String securityAnswer) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.securityAnswer = securityAnswer;
    }

    public UserModel(){

    }

    //Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }
    
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

    public List<BoardModel> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardModel> boards) {
        this.boards = boards;
    }
    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }
    
}
