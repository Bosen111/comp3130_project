package group16.backend.board.service;

import group16.backend.board.entity.BoardModel;
import group16.backend.board.repository.BoardRepository;
import group16.backend.board.service.BoardService;
import group16.backend.task.entity.TaskModel;
import group16.backend.task.repository.TaskRepository;
import group16.backend.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {


    private BoardRepository boardRepository = new BoardRepository() {
        @Override
        public List<BoardModel> findAll() {
            BoardModel boardModel = new BoardModel("Board1","Testing the board class");
            boardService.createBoard(boardModel);
            BoardModel boardModel2 = new BoardModel("Board2","Testing the board class");
            boardService.createBoard(boardModel);
            BoardModel boardModel3 = new BoardModel("Board3","Testing the board class");
            boardService.createBoard(boardModel);

            List<BoardModel> bmList = new ArrayList<>();
            bmList.add(boardModel);
            bmList.add(boardModel2);
            bmList.add(boardModel3);

            return bmList;
        }

        @Override
        public List<BoardModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<BoardModel> findAllById(Iterable<Long> aLong) {
            return null;
        }

        @Override
        public <S extends BoardModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends BoardModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends BoardModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<BoardModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> along) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public BoardModel getOne(Long along) {
            return null;
        }

        @Override
        public BoardModel getById(Long along) {
            return null;
        }

        @Override
        public BoardModel getReferenceById(Long along) {
            return null;
        }

        @Override
        public <S extends BoardModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends BoardModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<BoardModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends BoardModel> S save(S entity) {
            return entity;
        }

        @Override
        public Optional<BoardModel> findById(Long along) {
            long i = Long.valueOf(12345678910L);
            if (along == i){
                BoardModel boardModel = new BoardModel("Board1","Testing the board class");
                boardModel.setId(i);
                List<TaskModel> q = new ArrayList<>();
                TaskModel task = new TaskModel();
                task.setTaskName("test");
                task.setId(i);
                q.add(task);
                TaskModel task2 = new TaskModel();
                task2.setTaskName("test");
                long j = Long.valueOf(123456789L);
                task2.setId(j);
                q.add(task2);
                boardModel.setTasks(q);

                return Optional.of(boardModel);
            }
            return null;
        }

        @Override
        public boolean existsById(Long along) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long integer) {

        }

        @Override
        public void delete(BoardModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> aLong) {

        }

        @Override
        public void deleteAll(Iterable<? extends BoardModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends BoardModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends BoardModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends BoardModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends BoardModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends BoardModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    private TaskRepository taskRepository = new TaskRepository() {
        @Override
        public List<TaskModel> findAll() {
            List<TaskModel> l = new ArrayList<>();
            TaskModel task = new TaskModel();
            task.setTaskName("test");
            long i = Long.valueOf(12345678910L);
            task.setId(i);
            l.add(task);
            TaskModel task2 = new TaskModel();
            task2.setTaskName("test");
            long j = Long.valueOf(123456789L);
            task2.setId(j);
            l.add(task2);
            return l;
        }

        @Override
        public List<TaskModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<TaskModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends TaskModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends TaskModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends TaskModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<TaskModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public TaskModel getOne(Long aLong) {
            return null;
        }

        @Override
        public TaskModel getById(Long aLong) {
            return null;
        }

        @Override
        public TaskModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends TaskModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends TaskModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<TaskModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends TaskModel> S save(S entity) {
            return entity;
        }

        @Override
        public Optional<TaskModel> findById(Long aLong) {
            TaskModel task = new TaskModel();
            task.setTaskName("test");
            long i = Long.valueOf(12345678910L);
            task.setId(i);

            if(task.getId().equals(aLong)) {
                return Optional.of(task);
            }
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(TaskModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends TaskModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends TaskModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends TaskModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends TaskModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends TaskModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends TaskModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


    private TaskService taskService = new TaskService(){
        @Override
        public TaskModel findTaskByID(Long taskId) {
            TaskModel task = new TaskModel();
            task.setTaskName("test");
            long i = Long.valueOf(12345678910L);
            task.setId(i);
            return task;
        }
    };

    private BoardService boardService = new BoardService();


    @Test
    void createBoard() {
        BoardModel boardModel = new BoardModel("Board1","Testing the board class");
        boardService.boardRepository = boardRepository;
        Long i = boardService.createBoard(boardModel);
        assertEquals(i,boardModel.getId());
    }

    @Test
    void getBoards() {
        BoardModel boardModel = new BoardModel("Board1","Testing the board class");
        boardService.boardRepository = boardRepository;
        boardService.createBoard(boardModel);
        BoardModel boardModel2 = new BoardModel("Board2","Testing the board class");
        boardService.createBoard(boardModel);
        BoardModel boardModel3 = new BoardModel("Board3","Testing the board class");
        boardService.createBoard(boardModel);

        List<BoardModel> bmList = new ArrayList<>();
        bmList.add(boardModel);
        bmList.add(boardModel2);
        bmList.add(boardModel3);

        List<BoardModel> getBoardsList = boardService.getBoards();

        if(bmList.size() == getBoardsList.size()) {
            for (int x = 0; x < getBoardsList.size(); x++) {
                assertEquals(bmList.get(x).getId(),getBoardsList.get(x).getId());
            }
        }
    }

    @Test
    void deleteBoard(){
        BoardModel boardModel = new BoardModel("Board1","Testing the board class");
        boardService.boardRepository = boardRepository;
        Long l = Long.valueOf(123456L);
        boardModel.setId(l);
        boardService.createBoard(boardModel);
        boardService.deleteBoard(boardModel.getId());
        assertNull(boardService.boardRepository.findById(boardModel.getId()));
    }

    @Test
    void updateTask(){
        BoardModel boardModel = new BoardModel("Board1","Testing the board class");
        long i = Long.valueOf(12345678910L);
        boardModel.setId(i);
        boardService.boardRepository = boardRepository;
        boardService.taskService = taskService;
        boardService.createBoard(boardModel);
        TaskModel task = new TaskModel();
        task.setTaskName("test");
        task.setId(i);
        BoardModel bm = boardService.updateTask(i,task.getId());
        assertEquals(bm.getId(),boardModel.getId());
    }

    @Test
    void findBoardByID(){
        BoardModel boardModel = new BoardModel("Board1","Testing the board class");
        long i = Long.valueOf(12345678910L);
        boardModel.setId(i);
        boardService.boardRepository = boardRepository;
        BoardModel bm = boardService.findBoardByID(i);
        assertEquals(boardModel.getName(),bm.getName());
    }

    @Test
    void getAllTasksInBoard(){
        BoardModel boardModel = new BoardModel("Board1","Testing the board class");
        boardService.boardRepository = boardRepository;
        boardService.createBoard(boardModel);
        List<TaskModel> q = new ArrayList<>();
        TaskModel task = new TaskModel();
        task.setTaskName("test");
        long i = Long.valueOf(12345678910L);
        task.setId(i);
        q.add(task);
        TaskModel task2 = new TaskModel();
        task2.setTaskName("test");
        long j = Long.valueOf(123456789L);
        task2.setId(j);
        q.add(task2);
        boardModel.setTasks(q);

        List<TaskModel> check = boardService.getAllTasksInBoard(i);

        for(int x = 0; x < q.size(); x++){
            assertEquals(check.get(x).getId(),q.get(x).getId());
        }
    }
}