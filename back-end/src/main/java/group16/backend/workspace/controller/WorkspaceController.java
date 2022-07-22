package group16.backend.workspace.controller;

import com.fasterxml.jackson.annotation.*;
import group16.backend.board.entity.BoardModel;
import group16.backend.workspace.entity.Workspace;

import java.util.List;

import group16.backend.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("workspace")
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping(path = "/add")
    public String addWorkspace(@RequestBody Workspace workspace) {
        workspaceService.saveWorkspace(workspace);
        return "Workspace saved successfully";
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @DeleteMapping("/delete/{workspaceId}")
    public String deleteTask(@PathVariable Long workspaceId) {
        workspaceService.deleteWorkspace(workspaceId);
        return "Delete message send successfully";
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PutMapping("/assignUser/{workspaceId}/{userId}")
    public String assignUser(@PathVariable Long userId, @PathVariable Long workspaceId) {
        workspaceService.assignUser(userId, workspaceId);
        return "Adding user message send successfully";
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping("/getAll")
    public List<Workspace> getWorkspace() {
        return workspaceService.getWorkspace();
    }

//    @CrossOrigin(origins = {"http://localhost:3000"})
//    @PutMapping("/assignBoard/{workspaceId}/{boardId}")
//    public Workspace updateWorkspace(@PathVariable Long workspaceId, @PathVariable Long boardId) {
//        return workspaceService.updateBoard(workspaceId, boardId);
//    }
//
//    @CrossOrigin(origins = {"http://localhost:3000"})
//    @PutMapping("/getBoards/{workspaceId}")
//    public List<BoardModel> getBoards(@PathVariable Long workspaceId) {
//        return workspaceService.getAllBoards(workspaceId);
//    }

}
