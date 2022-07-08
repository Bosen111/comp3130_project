package group16.backend.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteBoard(Long boardId) {
        try {
            boardRepository.deleteById(boardId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BoardModel findBoardByID(Long boardId) {

        BoardModel boardModel = null;

        Optional<BoardModel> optionalBoardModel = boardRepository.findById(boardId);
        if(optionalBoardModel.isPresent()) {
            boardModel = optionalBoardModel.get();
        }

        return boardModel;

    }
}
