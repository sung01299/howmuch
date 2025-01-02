package io.github.sung01299.howmuch.domain.user.controller;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User API", description = "User related APIs")
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public User createUser(@RequestBody String userName) {
        User user = new User();
        user.setUserName(userName);
        Long createdId = userService.join(user);
        return user;
    }

    @GetMapping("/api/user")
    public List<User> getUsers() {
        return userService.findAll();
    }
}
