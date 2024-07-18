package ai.leantech.jpatest.service;

import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SimpleAspectOrientedProgrammingLoggingUserService {
    private final UserRepository userRepository;

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
