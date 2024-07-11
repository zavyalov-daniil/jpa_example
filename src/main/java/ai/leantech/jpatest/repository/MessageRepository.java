package ai.leantech.jpatest.repository;

import ai.leantech.jpatest.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
}
