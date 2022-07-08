package group16.backend.workspace.serviceImplementation;

import group16.backend.board.BoardModel;
import group16.backend.board.BoardRepository;
import group16.backend.board.BoardService;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;
import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;
import group16.backend.workspace.service.WorkspaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepo workspaceRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

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
    public List<Workspace> getWorkspace(){
        return workspaceRepo.findAll();
    }

    @Override
    public Workspace updateBoard(Long workspaceId, Long boardId) {

        Workspace updatedWorkspace = null;
        Optional<Workspace> workspace = null;

        try {

            workspace = workspaceRepo.findById(workspaceId);
            if(workspace.isPresent()) {

                Workspace workspaceModel = workspace.get();
                BoardModel boardModel = boardService.findBoardByID(boardId);

                List<BoardModel> boards = workspaceModel.getBoards();
                if(boards == null) {
                    boards = new ArrayList<>();
                }
                boards.add(boardModel);
                workspaceModel.setBoards(boards);

                updatedWorkspace = workspaceRepo.save(workspaceModel);

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return updatedWorkspace;
    }

    @Override
    public List<BoardModel> getAllBoards(Long workspaceId) {
        Optional<Workspace> workspace = workspaceRepo.findById(workspaceId);
        List<BoardModel> boards = null;

        try {
            if (workspace.isPresent()) {
                boards = workspace.get().getBoards();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return boards;
    }
}
