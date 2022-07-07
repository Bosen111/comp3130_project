package group16.backend.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Long createBoard(BoardModel board) {
        return boardRepository.save(board).getId();
    }

    public List<BoardModel> getBoards() {
        return boardRepository.findAll();
    }
}
