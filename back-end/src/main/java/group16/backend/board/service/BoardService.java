package group16.backend.board.service;

import group16.backend.board.entity.BoardModel;
import group16.backend.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Long createBoard(BoardModel board) {
        return boardRepository.save(board).getId();
    }

    public List<BoardModel> getBoards() {
        return boardRepository.findAll();
    }
}
