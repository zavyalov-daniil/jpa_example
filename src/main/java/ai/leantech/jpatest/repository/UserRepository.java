package ai.leantech.jpatest.repository;

import ai.leantech.jpatest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
