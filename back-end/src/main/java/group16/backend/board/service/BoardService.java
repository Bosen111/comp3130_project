package group16.backend.board.service;

import group16.backend.board.entity.BoardModel;
import group16.backend.board.repository.BoardRepository;
import group16.backend.task.entity.TaskModel;
import group16.backend.board.entity.BoardModel;
import group16.backend.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TaskService taskService;

    public Long createBoard(BoardModel board) {
        return boardRepository.save(board).getId();
    }

    public List<BoardModel> getBoards() {
        return boardRepository.findAll();
    }

    public void deleteBoard(Long boardId) {
        try {
            boardRepository.deleteById(boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BoardModel updateTask(Long boardId, Long taskId) {

        BoardModel updatedBoard = null;
        Optional<BoardModel> board = null;

        try {

            board = boardRepository.findById(boardId);
            if(board.isPresent()) {

                BoardModel boardModel = board.get();
                TaskModel taskModel = taskService.findTaskByID(taskId);

                List<TaskModel> tasks = boardModel.getTasks();
                if(tasks == null) {
                    tasks = new ArrayList<>();
                }
                tasks.add(taskModel);
                boardModel.setTasks(tasks);

                updatedBoard = boardRepository.save(boardModel);

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return updatedBoard;
    }

    public BoardModel findBoardByID(Long boardId) {

        BoardModel boardModel = null;

        Optional<BoardModel> optionalBoardModel = boardRepository.findById(boardId);
        if(optionalBoardModel.isPresent()) {
            boardModel = optionalBoardModel.get();
        }

        return boardModel;

    }

    public List<TaskModel> getAllTasksInBoard(Long boardId) {
        BoardModel boardModel = findBoardByID(boardId);

        return boardModel.getTasks();
    }
}
