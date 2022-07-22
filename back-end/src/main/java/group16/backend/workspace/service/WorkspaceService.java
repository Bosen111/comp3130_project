package group16.backend.workspace.service;

import group16.backend.board.repository.BoardRepository;
import group16.backend.board.service.BoardService;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;
import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WorkspaceService {

    @Autowired
    WorkspaceRepo workspaceRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

    public Workspace saveWorkspace(Workspace workspace) {
        try {
            workspace.setDescription(workspace.getDescription());
            workspace.setWorkspaceType(workspace.getWorkspaceType());
            workspace.setWorkspaceName(workspace.getWorkspaceName());
            workspaceRepo.save(workspace);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workspace;
    }

    public void deleteWorkspace(Long workspaceId) {
        try {
            workspaceRepo.deleteById(workspaceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void assignUser(Long userId, Long workspaceId) {
//        List<UserModel> users = null;
//        try {
//            UserModel user = userRepository.findById(userId).get();
//            Workspace workspace = workspaceRepo.findById(workspaceId).get();
//
//            users = workspace.getUsers();
//            users.add(user);
//
//            workspace.setUsers(users);
//            workspaceRepo.save(workspace);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public List<Workspace> getWorkspace() {
        return workspaceRepo.findAll();
    }
}
