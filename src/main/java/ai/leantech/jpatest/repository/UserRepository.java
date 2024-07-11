package ai.leantech.jpatest.repository;

import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.service.aspect.CallCthulhuAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @CallCthulhuAnnotation
    List<UserEntity> findAllByBirthAfter(LocalDateTime dateTime);
}
