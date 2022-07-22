package group16.backend.board.controller;

import group16.backend.board.entity.BoardModel;
import group16.backend.board.service.BoardService;
import group16.backend.task.entity.TaskModel;
import group16.backend.user.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static io.github.handsomecoder.utils.ObjectUtils.isNull;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("board")
@CrossOrigin(origins = {"http://localhost:3000"})
public class BoardController {

    @Autowired
    private BoardService boardService;

    public static final String ID = "id";

    @PostMapping("/createBoard")
    public ResponseEntity<Map<String, Long>> createBoard(@RequestBody BoardModel board) {
        long id = boardService.createBoard(board);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }

    @PutMapping("/updateBoard")
    public ResponseEntity<Map<String, Long>> updateBoard(@RequestBody BoardModel board) {
        long id = boardService.createBoard(board);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @DeleteMapping("/deleteBoard/{boardId}")
    public String deleteBoard(@PathVariable long boardId){
        boardService.deleteBoard(boardId);
        return "Delete message send successfully";
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PutMapping("/assignTask/{boardId}")
    public BoardModel updateTask(@PathVariable Long boardId, @RequestParam Long taskId) {

        return boardService.updateTask(boardId, taskId);

    }
    
    @GetMapping("/getAll")
    public List<BoardModel> getBoards() {
        return boardService.getBoards();
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping("/getAllTasks/{boardId}")
    public List<TaskModel> getTasks(@PathVariable Long boardId) {
        return boardService.getAllTasksInBoard(boardId);
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping("/getById/{boardId}")
    public BoardModel getBoardById(@PathVariable Long boardId){
        return boardService.findBoardByID(boardId);
    }
}

