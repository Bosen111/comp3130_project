package group16.backend.workspace.serviceImplementation;

import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;
import group16.backend.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepo workspaceRepo;

    @Override
    public void saveWorkspace(Workspace workspace) {
        try {
            workspace.setDescription(workspace.getDescription());
            workspace.setWorkspaceType(workspace.getWorkspaceType());
            workspace.setWorkspaceName(workspace.getWorkspaceName());
            workspaceRepo.save(workspace);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWorkspace(Integer workspaceId) {
        try {
            workspaceRepo.deleteById(workspaceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
