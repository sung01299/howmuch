package io.github.sung01299.howmuch.domain.user.service;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setUserName("강해린");

        Long savedId = userService.join(user);

        assertEquals(user, userRepository.findOne(savedId));
    }

    @Test
    public void findAll() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setUserName("강해린");
        user2.setUserName("김민지");
        user3.setUserName("윈터");

        userService.join(user1);
        userService.join(user2);
        userService.join(user3);

        assertEquals(3, userRepository.findAll().size());
    }
}