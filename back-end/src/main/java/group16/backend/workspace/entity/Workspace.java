package group16.backend.workspace.entity;

import javax.persistence.*;

@Entity
@Table(name = "workspace")
public class Workspace {
    public Workspace(String workspaceName, String description) {
        this.workspaceName = workspaceName;
        this.description = description;
    }

    public Workspace() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String workspaceName;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
