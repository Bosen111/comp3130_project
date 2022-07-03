package group16.backend.workspace.controller;

import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping(path = "/addWorkspace", consumes = "application/json", produces = "application/json")
    public String addWorkspace(@RequestBody Workspace workspace) {
        workspaceService.saveWorkspace(workspace);
        return "Workspace saved successfully";
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @DeleteMapping("/deleteWorkspace/{workspaceId}")
    public String deleteTask(@PathVariable Integer workspaceId){
        workspaceService.deleteWorkspace(workspaceId);
        return "Delete message send successfully";
    }

}
