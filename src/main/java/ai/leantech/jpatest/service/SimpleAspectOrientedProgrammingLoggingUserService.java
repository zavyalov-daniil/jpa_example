package ai.leantech.jpatest.service;

import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.repository.UserRepository;
import ai.leantech.jpatest.service.aspect.LogExecutionTime;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SimpleAspectOrientedProgrammingLoggingUserService {
    private final UserRepository userRepository;

    @LogExecutionTime
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAllUsersByBirthAfter(LocalDateTime dateTime) {
        if (dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Birth dateTime cannot be grater than the current date and time");
        }
        return userRepository.findAllByBirthAfter(dateTime);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
