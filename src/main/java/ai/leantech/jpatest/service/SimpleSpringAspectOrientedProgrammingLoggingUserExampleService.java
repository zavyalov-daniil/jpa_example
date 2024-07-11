package ai.leantech.jpatest.service;

import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SimpleSpringAspectOrientedProgrammingLoggingUserExampleService {
    private final UserRepository userRepository;

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAllUsers(LocalDateTime dateTime) {
        return userRepository.findAllByBirthAfter(dateTime);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
