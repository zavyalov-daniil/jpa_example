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
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ, proxyTargetClass = true)
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
                UserEntity u = new UserEntity(1, "Bjarne Stroustrup", LocalDateTime.of(1950, 12, 30, 12, 12), Instant.now(), null, new HashSet<>());
                //u.getRoles().add(role1);
				//UserEntity user = userRepository.save(u);
				userRepository.save(new UserEntity(2, "Linus Torvalds", LocalDateTime.of(1969, 12, 28, 12, 12), Instant.now(), null, null));
				userRepository.save(new UserEntity(3, "Robert Martin", LocalDateTime.of(1952, 12, 5, 12, 12), Instant.now(), null, null));
				userRepository.save(new UserEntity(4, "Alan Turing", LocalDateTime.of(1923, 6, 23, 12, 12), Instant.now(), null, null));
				roleRepository.save(new RoleEntity(UUID.randomUUID(), "Role", new HashSet<>()));
				roleRepository.save(new RoleEntity(UUID.randomUUID(), "Role", new HashSet<>()));
                //messageRepository.save(new MessageEntity(UUID.randomUUID(), "aaaa", user));
                return null;
            });
		};
	}
}
