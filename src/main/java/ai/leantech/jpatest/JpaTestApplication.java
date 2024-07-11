package ai.leantech.jpatest;

import ai.leantech.jpatest.entity.MessageEntity;
import ai.leantech.jpatest.entity.RoleEntity;
import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.repository.MessageRepository;
import ai.leantech.jpatest.repository.RoleRepository;
import ai.leantech.jpatest.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class JpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(PlatformTransactionManager transactionManager, RoleRepository roleRepository, UserRepository userRepository, MessageRepository messageRepository) {
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		return args -> {

			transactionTemplate.execute(status -> {
                messageRepository.deleteAll();
                userRepository.deleteAll();
                roleRepository.deleteAll();

                RoleEntity role1 = roleRepository.save(new RoleEntity(UUID.randomUUID(), "Role", new HashSet<>()));
                UserEntity u = new UserEntity(new Random().nextInt(), "User", LocalDateTime.now(), Instant.now(), null, new HashSet<>());
                u.getRoles().add(role1);
                UserEntity user = userRepository.save(u);
				roleRepository.save(new RoleEntity(UUID.randomUUID(), "Role", new HashSet<>()));
				roleRepository.save(new RoleEntity(UUID.randomUUID(), "Role", new HashSet<>()));
                messageRepository.save(new MessageEntity(UUID.randomUUID(), "aaaa", user));
                return null;
            });
		};
	}
}
