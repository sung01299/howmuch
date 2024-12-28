package io.github.sung01299.howmuch.user;

import io.github.sung01299.howmuch.domain.user.entity.User;
import io.github.sung01299.howmuch.domain.user.repository.UserRepository;
import io.github.sung01299.howmuch.domain.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(UserServiceImpl.class)
public class UserServiceImplTest {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @Autowired
    public UserServiceImplTest(UserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Test
    void join() {
        User user1 = new User();
        User user2 = new User();

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);

        userService.join(user1);
        userService.join(user2);

        List<User> allUsers = userRepository.findAll();
        for (User user: allUsers) {
            System.out.println(user.getUserId());
        }
    }
}
