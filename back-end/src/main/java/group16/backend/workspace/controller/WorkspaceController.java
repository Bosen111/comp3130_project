package group16.backend.workspace.controller;

import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @PostMapping(path = "/addWorkspace", consumes = "application/json", produces = "application/json")
    public String addWorkspace(@RequestBody Workspace workspace) {
        workspaceService.saveWorkspace(workspace);
        return "Data saved successfully";
    }

}
