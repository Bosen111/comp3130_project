package group16.backend.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group16.backend.task.entity.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    
}
