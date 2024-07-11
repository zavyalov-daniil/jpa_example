package ai.leantech.jpatest.repository;

import ai.leantech.jpatest.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
