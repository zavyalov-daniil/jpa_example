package ai.leantech.jpatest;

import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserRepository userRepository;
    @GetMapping()
    List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
