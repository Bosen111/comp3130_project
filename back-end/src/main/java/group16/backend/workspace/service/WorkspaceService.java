package group16.backend.workspace.service;

import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class WorkspaceService {
    @Autowired
    WorkspaceRepo workspaceRepo;


    public Workspace saveWorkspace(Workspace workspace) {
        return workspaceRepo.save(workspace);
    }

    public void deleteWorkspace(Long workspaceId) {

        Optional<Workspace> workspace = workspaceRepo.findById(workspaceId);
        if(workspace.isPresent()){
            workspaceRepo.deleteById(workspaceId);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Workspace does not exist");
        }
    }
}
