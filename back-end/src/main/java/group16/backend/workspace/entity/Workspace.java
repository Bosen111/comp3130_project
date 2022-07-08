package group16.backend.workspace.entity;

import java.util.List;
import javax.persistence.*;
import group16.backend.board.BoardModel;
import group16.backend.user.entity.UserModel;

@Entity
@Table(name = "workspace")
public class Workspace {
    public Workspace(String workspaceName, String workspaceType, String description) {
        this.workspaceName = workspaceName;
        this.workspaceType = workspaceType;
        this.description = description;
    }

    public Workspace() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workspaceId;

    private String workspaceName;

    private String workspaceType;

    private String description;

    @ManyToMany
    @JoinTable (name = "users_workspaces",
        joinColumns = @JoinColumn(name = "workspaceId"),
        inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<UserModel> users;

    @OneToMany(targetEntity = BoardModel.class)
    @JoinColumn(name = "fk_workspaceId", referencedColumnName = "workspaceId")
    private List<BoardModel> boards;

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public String getWorkspaceType() {
        return workspaceType;
    }

    public void setWorkspaceType(String workspaceType) {
        this.workspaceType = workspaceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public List<BoardModel> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardModel> boards) {
        this.boards = boards;
    }
}
