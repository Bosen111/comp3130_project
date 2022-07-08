package group16.backend.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static group16.backend.constant.ApplicationConstant.ID;
import static io.github.handsomecoder.utils.ObjectUtils.isNull;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("board")
@CrossOrigin(origins = {"http://localhost:3000"})
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/createBoard")
    public ResponseEntity<Map<String, Integer>> createBoard(@RequestBody BoardModel board) {
        Integer id = boardService.createBoard(board);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }

    @PutMapping("/updateBoard")
    public ResponseEntity<Map<String, Integer>> updateBoard(@RequestBody BoardModel board) {
        Integer id = boardService.createBoard(board);
        HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
        return status(status).body(singletonMap(ID, id));
    }
    
    @GetMapping("/getAll")
    public List<BoardModel> getBoards() {
        return boardService.getBoards();
    }

}

