package group16.backend.workspace.service;

import group16.backend.board.BoardModel;
import group16.backend.workspace.entity.Workspace;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface WorkspaceService {
    public void saveWorkspace(Workspace workspace);
    public void deleteWorkspace(Long workspaceId);
    public void assignUser(Long userId, Long workspaceId);
    public List<Workspace> getWorkspace();
    public Workspace updateBoard(Long workspaceId, Long taskId);
    public List<BoardModel> getAllBoards(Long workspaceId);
}
