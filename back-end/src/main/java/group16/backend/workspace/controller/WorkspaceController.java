package group16.backend.workspace.controller;

import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @CrossOrigin
    @PostMapping(path = "/add")
    public String addWorkspace(@RequestBody Workspace workspace) {
        workspaceService.saveWorkspace(workspace);
        return "Workspace saved successfully";
    }

    @CrossOrigin
    @DeleteMapping("/delete/{workspaceId}")
    public String deleteTask(@PathVariable Long workspaceId) {
        workspaceService.deleteWorkspace(workspaceId);
        return "Delete message send successfully";
    }

    @CrossOrigin
    @GetMapping("/get/{workspaceId}")
    public void getBoards(@PathVariable Long workspaceId) {
        workspaceService.getBoards(workspaceId);
    }

    @CrossOrigin
    @PutMapping("/assignUser/{workspaceId}/{userId}")
    public String assignUser(@PathVariable Long userId, @PathVariable Long workspaceId) {
        workspaceService.assignUser(userId, workspaceId);
        return "Adding user message send successfully";
    }

}
