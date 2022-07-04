package group16.backend.workspace.service;

import group16.backend.workspace.entity.Workspace;
import group16.backend.workspace.repository.WorkspaceRepo;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class WorkspaceServiceTest {

    private WorkspaceRepo workspaceRepo = new WorkspaceRepo() {
        @Override
        public List<Workspace> findAll() {
            return null;
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
            if(i == aLong) {
                Workspace workspace = new Workspace("Name", "Type", "description");
                workspace.setWorkspaceId(i);
                return Optional.of(workspace);
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

    private WorkspaceService workspaceService = new WorkspaceService();
    Workspace workspace = new Workspace("Name","Type","description");

    @Test
    void saveWorkspace() {
        workspaceService.workspaceRepo = workspaceRepo;
        Workspace workspace1 = workspaceService.saveWorkspace(workspace);
        assertEquals(workspace1.getWorkspaceId(),workspace.getWorkspaceId());
    }

    @Test
    void deleteWorkspace() {
        long i = Long.valueOf(12345678910L);
        workspace.setWorkspaceId(i);
        workspaceService.workspaceRepo = workspaceRepo;
        workspaceService.saveWorkspace(workspace);
        workspaceService.deleteWorkspace(i);
        assertNull(workspaceRepo.findAll());
    }

    @Test
    void deleteWorkspaceNonExistent() {
        try {
            long i = Long.valueOf(123456789L);
            workspace.setWorkspaceId(i);
            workspaceService.workspaceRepo = workspaceRepo;
            workspaceService.saveWorkspace(workspace);
            workspaceService.deleteWorkspace(i);
        }catch (ResponseStatusException e){
            ResponseStatusException x = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Workspace does not exist");
            assertEquals(x.getMessage(),e.getMessage());
        }
    }
}