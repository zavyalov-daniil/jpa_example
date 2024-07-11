package ai.leantech.jpatest.controller;

import ai.leantech.jpatest.entity.UserEntity;
import ai.leantech.jpatest.service.SpringAspectOrientedProgrammingLoggingUserExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SpringAspectOrientedProgrammingLoggingUserExampleService service;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return service.saveUser(user);
    }

    @GetMapping
    public List<UserEntity> findAllUsers() {
        return service.findAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
    }
}
