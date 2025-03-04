package io.github.sung01299.howmuch.domain.user.controller;

import io.github.sung01299.howmuch.domain.user.dto.RegisterDTO;
import io.github.sung01299.howmuch.domain.user.dto.UserExistsResponseDTO;
import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User API", description = "User related APIs")
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public User createUser(@RequestBody RegisterDTO userName) {
        User user = new User();
        user.setUserName(userName.getUserName());
        Long createdId = userService.join(user);
        return user;
    }

    @GetMapping("/api/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/api/user/{userName}")
    public UserExistsResponseDTO checkUserExists(@PathVariable("userName") String userName) {
        User user = userService.findOne(userName);
        UserExistsResponseDTO userExists = new UserExistsResponseDTO();
        if (user != null) {
            userExists.setUserId(user.getUserId());
            userExists.setExist(true);
        } else {
            userExists.setExist(false);
        }
        return userExists;
    }
}
