package group16.backend.workspace.repository;

import group16.backend.workspace.entity.Workspace;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkspaceRepo extends JpaRepository<Workspace, Long> {

}
