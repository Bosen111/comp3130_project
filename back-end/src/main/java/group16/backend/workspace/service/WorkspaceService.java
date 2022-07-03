package group16.backend.workspace.service;

import group16.backend.workspace.entity.Workspace;
import org.springframework.stereotype.Service;

@Service
public interface WorkspaceService {
    public void saveWorkspace(Workspace workspace);
    public void deleteWorkspace(Integer workspaceId);
}
