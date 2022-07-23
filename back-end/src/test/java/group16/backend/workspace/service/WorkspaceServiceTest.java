package group16.backend.workspace.service;

import group16.backend.board.entity.BoardModel;
import group16.backend.user.entity.UserModel;
import group16.backend.user.repository.UserRepository;
import group16.backend.user.service.UserService;
import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class WorkspaceServiceTest {

    private WorkspaceRepo workspaceRepo = new WorkspaceRepo() {
        @Override
        public List<Workspace> findAll() {
            Workspace workspace = new Workspace("Name", "Type", "description");
            List<Workspace> workspaces = new ArrayList<>();
            workspaces.add(workspace);
            Workspace workspace1 = new Workspace("test1", "t", "des");
            workspaces.add(workspace1);
            return workspaces;
        }

        @Override
        public List<Workspace> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Workspace> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Workspace> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Workspace> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Workspace> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Workspace> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Workspace getOne(Long aLong) {
            return null;
        }

        @Override
        public Workspace getById(Long aLong) {
            return null;
        }

        @Override
        public Workspace getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Workspace> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Workspace> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Workspace> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Workspace> S save(S entity) {
            return entity;
        }

        @Override
        public Optional<Workspace> findById(Long aLong) {
            long i = Long.valueOf(12345678910L);
            if (i == aLong) {
                Workspace workspace = new Workspace("Name", "Type", "description");
                workspace.setWorkspaceId(i);
                return Optional.of(workspace);
            }
            return null;
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
        public void delete(Workspace entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Workspace> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Workspace> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Workspace> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Workspace> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Workspace> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Workspace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


    private UserRepository userRepository = new UserRepository() {
        @Override
        public Optional<UserModel> findByEmail(String email) {
            return Optional.empty();
        }

        @Override
        public List<UserModel> findAll() {
            return null;
        }

        @Override
        public List<UserModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<UserModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserModel getOne(Long aLong) {
            return null;
        }

        @Override
        public UserModel getById(Long aLong) {
            return null;
        }

        @Override
        public UserModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserModel> S save(S entity) {
            return null;
        }

        @Override
        public Optional<UserModel> findById(Long aLong) {
            UserModel um = new UserModel();
            um.setEmail("796@gmail.com");
            um.setPassword("8967");
            um.setId(aLong);
            return Optional.of(um);
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
        public void delete(UserModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends UserModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

    };


    private WorkspaceService workspaceService = new WorkspaceService();
    Workspace workspace = new Workspace("Name", "Type", "description");

    @Test
    void saveWorkspace() {
        workspaceService.workspaceRepo = workspaceRepo;
        Workspace workspace1 = workspaceService.saveWorkspace(workspace);
        assertEquals(workspace1.getWorkspaceId(), workspace.getWorkspaceId());
    }

    @Test
    void deleteWorkspace() {
        long i = Long.valueOf(123456780L);
        workspace.setWorkspaceId(i);
        workspaceService.workspaceRepo = workspaceRepo;
        workspaceService.saveWorkspace(workspace);
        workspaceService.deleteWorkspace(i);
        assertNull(workspaceService.workspaceRepo.findById(i));
    }


    /*@Test
    void assignUser(){
        UserModel um = new UserModel();
        um.setEmail("0796@gmail.com");
        um.setPassword("8967");
        UserModel um2 = new UserModel();
        um.setEmail("1796@gmail.com");
        um.setPassword("8967");
        UserModel um3 = new UserModel();
        um.setEmail("2796@gmail.com");
        um.setPassword("8967");
        long i = Long.valueOf(12345678910L);
        um.setId(i);

        List<UserModel> userModels = new ArrayList<>();
        userModels.add(um);
        userModels.add(um2);
        userModels.add(um3);

        workspace.setWorkspaceId(i);
        workspaceService.workspaceRepo = workspaceRepo;
        workspaceService.userRepository = userRepository;
        workspaceService.saveWorkspace(workspace);
        workspaceService.assignUser(i,workspace.getWorkspaceId());
        List<UserModel> users = workspace.getUsers();

        if(userModels.size() == users.size()) {
                for (int x = 0; x < users.size(); x++) {
                assertEquals(userModels.get(x).getEmail(), users.get(x).getEmail());
            }
        }
    }*/

    @Test
    void getWorkspace(){
        List<Workspace> workspaces = new ArrayList<>();
        workspaces.add(workspace);
        Workspace workspace1 = new Workspace("test1", "t", "des");
        workspaces.add(workspace1);
        workspaceService.workspaceRepo = workspaceRepo;
        workspaceService.saveWorkspace(workspace);
        workspaceService.saveWorkspace(workspace1);
        List<Workspace> workspaceList = workspaceService.getWorkspace();

        for (int i = 0; i < workspaceList.size(); i++){
            assertEquals(workspaceList.get(i).getWorkspaceName() , workspaces.get(i).getWorkspaceName());
        }
    }
}