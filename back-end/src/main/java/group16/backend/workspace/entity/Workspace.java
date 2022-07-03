package group16.backend.workspace.entity;

import javax.persistence.*;

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
    private Integer workspaceId;

    private String workspaceName;

    private String workspaceType;

    private String description;

    public Integer getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(Integer workspaceId) {
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
}
