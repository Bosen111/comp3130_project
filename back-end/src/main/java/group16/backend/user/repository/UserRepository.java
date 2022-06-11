package group16.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group16.backend.user.entity.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}
