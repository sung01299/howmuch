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
        System.out.println("User: " + userName.toString());
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
        Boolean exists = userService.findOne(userName);
        UserExistsResponseDTO userExists = new UserExistsResponseDTO();
        userExists.setExist(exists);
        return userExists;
    }
}
