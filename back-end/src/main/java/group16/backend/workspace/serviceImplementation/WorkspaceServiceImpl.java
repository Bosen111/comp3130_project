package group16.backend.workspace.serviceImplementation;

import group16.backend.board.BoardModel;
import group16.backend.board.BoardRepository;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;
import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;
import group16.backend.workspace.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepo workspaceRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

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
    public void deleteWorkspace(Long workspaceId) {
        try {
            workspaceRepo.deleteById(workspaceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void assignUser(Long userId, Long workspaceId) {
        List<UserModel> users = null;
        try {
            UserModel user = userRepository.findById(userId).get();
            Workspace workspace = workspaceRepo.findById(workspaceId).get();

            users = workspace.getUsers();
            users.add(user);

            workspace.setUsers(users);
            workspaceRepo.save(workspace);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getBoards(Long workspaceId) {
        List<BoardModel> boards = null;
        BoardModel board = boardRepository.findById(workspaceId).get();
    }
}
